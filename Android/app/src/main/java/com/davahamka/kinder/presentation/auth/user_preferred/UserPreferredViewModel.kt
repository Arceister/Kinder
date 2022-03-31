package com.davahamka.kinder.presentation.auth.user_preferred

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davahamka.kinder.static.UserReferenceStatic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPreferredViewModel @Inject constructor(

): ViewModel() {

    var dataOptions by mutableStateOf<List<String>>(emptyList())
        private set

    init {
        viewModelScope.launch {
//            _dataOptions.value = UserReferenceStatic.referredData
        }
    }

    fun onEvent(event: UserPreferredEvent) {
        when(event) {
            is UserPreferredEvent.OnNextPage -> {

            }
            is UserPreferredEvent.OnSelectOption -> {
                if (dataOptions.contains(event.choose)) {
                    dataOptions = dataOptions - event.choose
                } else {
                    dataOptions = dataOptions + event.choose
                }
             }
        }
    }
}
