package mx.yobijoss.matrices.modules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DynamicModulesRepository {

    private val onDemandPackageName = "com.yobibyte.matrices.operation_ondemand"
    private val operationsModuleName = "dynamic_operations"

    fun  getModules() : LiveData<List<Module>> {
        val modules = MutableLiveData<List<Module>>()

        modules.value = listOf(
                Module("Transpuesta Matriz 1", "TransposedMatrixOperation")
        )

        return modules
    }

}
