package com.example.cryptoapp.di

import android.content.Context
import com.example.cryptoapp.data.remote.ApiRoutes
import com.example.cryptoapp.data.remote.ApiServiceAuth
import com.example.cryptoapp.data.remote.ApiServiceCoin
import com.example.cryptoapp.data.remote.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.repository.CoinRepository
import com.example.cryptoapp.service.SharedPreferencesService

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideMySharedPref(context: Context): SharedPreferencesService {
        return SharedPreferencesService(context)
    }

    @Provides
    @Singleton
    fun provideKotlinJsonAdapterFactory(): KotlinJsonAdapterFactory = KotlinJsonAdapterFactory()

    @Provides
    @Singleton
    fun provideMoshi(kotlinJsonAdapterFactory: KotlinJsonAdapterFactory): Moshi = Moshi.Builder()
        .add(kotlinJsonAdapterFactory)
        .build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BASIC //BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()


    @Provides
    @Singleton
    @Named("Auth")
    fun provideRetrofitClient(
        okHttp: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttp)
        .baseUrl(ApiRoutes.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideApiService(@Named("Auth") retrofit: Retrofit): ApiServiceAuth = retrofit.create(
        ApiServiceAuth::class.java)

    @Provides
    @Singleton
    @Named("Coin")
    fun provideRetrofitClient2(
        okHttp: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttp)
        .baseUrl(ApiRoutes.COIN_PAPRIKA_URL)
        .build()

    @Provides
    @Singleton
    fun provideApiService2(@Named("Coin") retrofit: Retrofit): ApiServiceCoin = retrofit.create(
        ApiServiceCoin::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: ApiServiceCoin): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}