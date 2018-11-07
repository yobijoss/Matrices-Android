package mx.yobibytelabs.matrices.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import mx.yobibytelabs.matrices.fragments.MatrixFragment
import mx.yobibytelabs.matrices.model.MatrixType

class MatrixPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    val titles = arrayOf("Matriz 1", "Matriz 2", "Resultado")

    override fun getItem(i: Int): Fragment {
        return when (i) {
            0 -> MatrixFragment.newInstance(MatrixType.Operator_1)
            1 -> MatrixFragment.newInstance(MatrixType.Operator_2)
            else -> MatrixFragment.newInstance(MatrixType.Result)
        }
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}
