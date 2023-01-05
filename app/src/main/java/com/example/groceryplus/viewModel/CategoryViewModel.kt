package com.example.groceryplus.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.groceryplus.model.Repository
import com.example.groceryplus.model.remote.data.CategoryData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val categoryResponse = MutableLiveData<CategoryData>()
    val error = MutableLiveData<String>()
    val progress = MutableLiveData<Boolean>()
    private lateinit var disposable: Disposable

    fun getCategory() {
        disposable = repository.getCategoryData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    categoryResponse.postValue(it)
                },
                {
                    error.postValue(it.toString())
                }
            )
    }

    override fun onCleared() {
        super.onCleared()
        if (this::disposable.isInitialized) {
            disposable.dispose()
        }
    }
}