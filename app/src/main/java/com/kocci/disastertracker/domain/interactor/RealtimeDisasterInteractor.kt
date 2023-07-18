package com.kocci.disastertracker.domain.interactor

import com.kocci.disastertracker.data.repository.AppRepository
import com.kocci.disastertracker.domain.usecase.RealtimeDisasterUseCase
import javax.inject.Inject

class RealtimeDisasterInteractor @Inject constructor(
    private val repository: AppRepository
) : RealtimeDisasterUseCase {

}