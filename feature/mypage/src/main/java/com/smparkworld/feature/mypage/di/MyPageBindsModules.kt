package com.smparkworld.feature.mypage.di

import com.smparkworld.feature.mypage.data.FakeMyPageRepositoryImpl
import com.smparkworld.feature.mypage.data.MyPageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MyPageRepositoryModule {

    @Binds
    @Singleton
    fun bindMyPageRepository(repository: FakeMyPageRepositoryImpl): MyPageRepository
}