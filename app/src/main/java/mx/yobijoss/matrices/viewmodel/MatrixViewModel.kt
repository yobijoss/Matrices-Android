package mx.yobijoss.matrices.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.yobijoss.matrices.operations.AddOperation
import mx.yobijoss.matrices.operations.MultiplyOperation
import mx.yobijoss.matrices.model.Operation

class MatrixViewModel : ViewModel() {
    val matrix1 : MutableLiveData<Array<DoubleArray>> = MutableLiveData()
    val matrix2 : MutableLiveData<Array<DoubleArray>> = MutableLiveData()
    val matrixResult : MutableLiveData<Array<DoubleArray>> = MutableLiveData()
    val matrixOperationList = listOf(AddOperation(), MultiplyOperation())
    var currentOperation = matrixOperationList[0];

    init {
        matrix1.value = Operation.EMPTY_MATRIX
        matrix2.value = Operation.EMPTY_MATRIX
    }

    fun operate () {
        matrixResult.value = currentOperation.operate(matrix1.value!!, matrix2.value!!)
    }

    fun changeOperation(selectedOperationIndex: Int) {
        currentOperation = matrixOperationList[selectedOperationIndex]
        operate()
    }
}