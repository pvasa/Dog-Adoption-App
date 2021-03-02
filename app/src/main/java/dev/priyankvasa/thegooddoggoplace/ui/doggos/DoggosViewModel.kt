package dev.priyankvasa.thegooddoggoplace.ui.doggos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.priyankvasa.thegooddoggoplace.model.DoggoRepo
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class DoggosViewModel : ViewModel() {
    private val doggoRepo = DoggoRepo()

    val doggos: LiveData<List<DoggoImage>> =
        liveData { emit(doggoRepo.getDoggos().images) }
}
