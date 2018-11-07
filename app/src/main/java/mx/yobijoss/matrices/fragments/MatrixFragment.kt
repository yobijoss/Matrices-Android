package mx.yobijoss.matrices.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.layout_matriz_4_4.*
import mx.yobijoss.matrices.R
import mx.yobijoss.matrices.model.MatrixType
import mx.yobijoss.matrices.ui.double
import mx.yobijoss.matrices.viewmodel.MatrixViewModel

class MatrixFragment : Fragment(), TextWatcher {

    private lateinit var matrixType: MatrixType
    private lateinit var viewModel: MatrixViewModel

    companion object {
        const val MATRIX_TYPE_KEY = "matrixTypeKey"

        fun newInstance(type: MatrixType): MatrixFragment {
            val matrixFragment = MatrixFragment()
            val bundle = Bundle()
            bundle.putSerializable(MATRIX_TYPE_KEY, type);
            matrixFragment.arguments = bundle
            return matrixFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        matrixType = arguments?.getSerializable(MATRIX_TYPE_KEY) as MatrixType
        viewModel = ViewModelProviders.of(activity!!).get(MatrixViewModel::class.java)

        if (matrixType == MatrixType.Result) {
            viewModel.matrixResult.observe(this, Observer {
                setValues(it)
            })
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_matriz_4_4, container, false)
        if (matrixType != MatrixType.Result) {
            setInputListener(view)
        }
        return view
    }

    private fun setInputListener(view: View) {
        var index = 0
        for (i in 0..3) {
            for (j in 0..3) {
                val editChild = (view as ConstraintLayout).getChildAt(index++)
                (editChild as EditText).addTextChangedListener(this)
                editChild.isEnabled = true
            }
        }
    }


    private fun operate() {
        if(matrixType == MatrixType.Operator_1) {
            viewModel.matrix1.value = getValues()
            viewModel.operate()
        } else if(matrixType == MatrixType.Operator_2) {
            viewModel.matrix2.value = getValues()
            viewModel.operate()
        }

    }

    private fun setValues(matrix: Array<DoubleArray>) {
        var index = 0
        for (i in 0..3) {
            for (j in 0..3) {
                val editChild = (view as ConstraintLayout).getChildAt(index++)
                (editChild as EditText).setText(String.format("%.2f", matrix[i][j]))
            }
        }
    }

    private fun getValues(): Array<DoubleArray> {
        return arrayOf(
                doubleArrayOf(
                    editText00.double(),
                    editText01.double(),
                    editText02.double(),
                    editText03.double()
                ),
                doubleArrayOf(
                        editText10.double(),
                        editText11.double(),
                        editText12.double(),
                        editText13.double()
                ),
                doubleArrayOf(
                        editText20.double(),
                        editText21.double(),
                        editText22.double(),
                        editText23.double()
                ),
                doubleArrayOf(
                        editText30.double(),
                        editText31.double(),
                        editText32.double(),
                        editText33.double()
                )
        )
    }

    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        operate()
    }
}
