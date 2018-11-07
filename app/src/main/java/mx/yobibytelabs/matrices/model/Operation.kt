package mx.yobibytelabs.matrices.model

abstract class Operation {

    companion object {
        val EMPTY_MATRIX: Array<DoubleArray> = arrayOf(DoubleArray(4), DoubleArray(4), DoubleArray(4), DoubleArray(4))
    }

    abstract fun getName(): String
    abstract fun operate(matrix1: Array<DoubleArray>, matrix2: Array<DoubleArray>): Array<DoubleArray>
}
