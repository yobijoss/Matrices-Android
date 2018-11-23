package mx.yobijoss.matrices.viewmodel

import androidx.lifecycle.ViewModel
import mx.yobijoss.matrices.modules.DynamicModulesRepository

class DynamicModulesViewModel : ViewModel() {

    val dynamicModulesManager = DynamicModulesRepository()

}
