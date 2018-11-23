package mx.yobijoss.matrices.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.google.android.play.core.splitinstall.*
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import kotlinx.android.synthetic.main.activity_main.*
import mx.yobijoss.matrices.R
import mx.yobijoss.matrices.adapters.MatrixPagerAdapter
import mx.yobijoss.matrices.modules.DynamicModulesUtil
import mx.yobijoss.matrices.viewmodel.DynamicModulesViewModel
import mx.yobijoss.matrices.viewmodel.MatrixViewModel


class OperationActivity : AppCompatActivity(), OnItemSelectedListener, SplitInstallStateUpdatedListener {

    private lateinit var matrixViewModel: MatrixViewModel
    private lateinit var dynamicOperationViewModel: DynamicModulesViewModel

    private lateinit var splitInstallManager: SplitInstallManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        matrixViewModel = ViewModelProviders.of(this).get(MatrixViewModel::class.java)
        dynamicOperationViewModel = ViewModelProviders.of(this).get(DynamicModulesViewModel::class.java)

        splitInstallManager = SplitInstallManagerFactory.create(this)


        val matrixPagerAdapter = MatrixPagerAdapter(supportFragmentManager)
        viewPagerMatrix.adapter = matrixPagerAdapter
        tabLayoutMatrix.setupWithViewPager(viewPagerMatrix)

        val expandedList = matrixViewModel.operationList.map { it.getName() }

        spinnerOperations.adapter = ArrayAdapter(this, R.layout.item_spinner_operation, expandedList)
        spinnerOperations.onItemSelectedListener = this
    }

    override fun onNothingSelected(parentView: AdapterView<*>?) {
    }

    override fun onItemSelected(parentView: AdapterView<*>?, selectedItem: View?, position: Int, id: Long) {
        if (position <2) {
            matrixViewModel.changeOperation(position)
        } else {
            loadNewOperations(position)
        }
    }

    override fun onResume() {
        splitInstallManager.registerListener(this)
        super.onResume()
    }

    override fun onPause() {
        splitInstallManager.unregisterListener(this)
        super.onPause()
    }

    override fun onStateUpdate(state: SplitInstallSessionState) {
        state.moduleNames().forEach { name ->
            // Handle changes in state.
            when (state.status()) {
                SplitInstallSessionStatus.DOWNLOADING -> {
                    //  In order to see this, the application has to be uploaded to the Play Store.
                    Toast.makeText(this, "Descargando modulo $name", Toast.LENGTH_SHORT).show()
                }
                SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                    /*
                      This may occur when attempting to download a sufficiently large module.

                      In order to see this, the application has to be uploaded to the Play Store.
                      Then features can be requested until the confirmation path is triggered.
                     */
                    startIntentSender(state.resolutionIntent()?.intentSender, null, 0, 0, 0)
                }
                SplitInstallSessionStatus.INSTALLED -> {
                    onSuccessfulLoad(name)
                    Toast.makeText(this, "modulo $name Instalado correctamente", Toast.LENGTH_SHORT).show()
                }

                SplitInstallSessionStatus.INSTALLING -> {
                    Toast.makeText(this, "Instalando modulo $name", Toast.LENGTH_SHORT).show()
                }
                SplitInstallSessionStatus.FAILED -> {
                    Toast.makeText(this, "Error al Instalar el modulo $name", Toast.LENGTH_SHORT).show()

                }
            }
        }

    }

    private fun loadNewOperations(position: Int) {
        Toast.makeText(this, "Cargando Operaciones nuevas", Toast.LENGTH_SHORT).show()

        if (splitInstallManager.installedModules.contains(dynamicOperationModuleName)) {
            Toast.makeText(this, "Ya Instalada", Toast.LENGTH_SHORT).show()
            onSuccessfulLoad(position)
            return
        }

        requestedIndex = position;
        val request = SplitInstallRequest.newBuilder()
                .addModule(dynamicOperationModuleName)
                .build()

        splitInstallManager.startInstall(request)

        Toast.makeText(this, "Empezando instalación de operaciones nuevas", Toast.LENGTH_SHORT).show()
    }

    private fun onSuccessfulLoad(operationIndex: String) {
        val transposedOperation = DynamicModulesUtil.loadNewOperationInstance()

        matrixViewModel.operationList.add(transposedOperation);
        matrixViewModel.changeOperation(operationIndex)
    }


}
