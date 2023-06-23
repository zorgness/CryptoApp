package com.example.cryptoapp.domain.use_case.get_coins

import com.example.cryptoapp.Resource
import com.example.cryptoapp.data.remote.dto.coin.toCoin
import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

        try {

            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(data = coins))


        } catch (he: HttpException) {

            emit(Resource.Error(he.localizedMessage ?: "An unexpected error occurred"))

        } catch (ioe: IOException) {
            emit(Resource.Error("Cannot reach server, check your network connection"))
        }

    }
}