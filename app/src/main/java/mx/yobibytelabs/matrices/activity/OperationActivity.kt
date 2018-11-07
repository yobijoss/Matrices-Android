package mx.yobibytelabs.matrices.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import mx.yobibytelabs.matrices.R
import mx.yobibytelabs.matrices.adapters.MatrixPagerAdapter
import mx.yobibytelabs.matrices.model.AddOperation
import mx.yobibytelabs.matrices.viewmodel.MatrixViewModel


class OperationActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var viewModel: MatrixViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(MatrixViewModel::class.java)

        val matrixPagerAdapter = MatrixPagerAdapter(supportFragmentManager)
        viewPagerMatrix.adapter = matrixPagerAdapter
        tabLayoutMatrix.setupWithViewPager(viewPagerMatrix)

        spinnerOperations.adapter = ArrayAdapter(this, R.layout.item_spinner_operation, viewModel.matrixOperationList.map { it.getName() })
        spinnerOperations.onItemSelectedListener = this
    }

    override fun onNothingSelected(parentView: AdapterView<*>?) {
    }

    override fun onItemSelected(parentView: AdapterView<*>?, selectedItem: View?, position: Int, id: Long) {
        viewModel.changeOperation(position)
    }
}
