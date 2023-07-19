package com.kocci.disastertracker.di

import com.kocci.disastertracker.data.source.remote.service.ApiService
import com.kocci.disastertracker.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val gsonConverter = GsonConverterFactory.create()
        return Retrofit
            .Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(gsonConverter)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}