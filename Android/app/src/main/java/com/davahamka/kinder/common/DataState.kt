package com.davahamka.kinder.common

data class DataState<T>(
    val message: String? = null,
    val data: T? = null,
    val isLoading: Boolean = false
) {
    companion object {
        fun <T> error(
        message: String,
        data: T? = null
        ): DataState<T> {
            return DataState(
                message = message,
                data = data
            )
        }

        fun <T> data(
            message: String? = null,
            data: T? = null
        ): DataState<T> {
            return DataState(
                message = message,
                data = data
            )
        }

        fun <T> loading(): DataState<T> =
            DataState(isLoading = true)
    }
}
