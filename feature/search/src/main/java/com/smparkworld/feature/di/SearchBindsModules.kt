package com.smparkworld.feature.di

import com.smparkworld.feature.data.search.FakeSearchRepositoryImpl
import com.smparkworld.feature.data.search.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SearchRepositoryBindsModule {

    @Binds
    @Singleton
    fun bindSearchRepository(repository: FakeSearchRepositoryImpl): SearchRepository
}