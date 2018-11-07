package mx.yobibytelabs.matrices.model

import mx.yobibytelabs.matrices.model.Operation

class MultiplyOperation : Operation() {
    override fun getName() = "Multiplicación"

    override fun operate(matrix1: Array<DoubleArray>, matrix2: Array<DoubleArray>): Array<DoubleArray> {
        val resultArray = EMPTY_MATRIX

        for (i in 0..3) {
            for (j in 0..3) {
                for (k in 0..3) {
                    resultArray[i][j] += matrix1[i][k] * matrix2[k][j]
                }
            }
        }
        return resultArray
    }
}
