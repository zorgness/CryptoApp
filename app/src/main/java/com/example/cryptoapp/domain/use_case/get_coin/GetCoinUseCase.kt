package com.example.cryptoapp.domain.use_case.get_coin

import com.example.cryptoapp.Resource
import com.example.cryptoapp.data.remote.dto.coin.toCoinDetail
import com.example.cryptoapp.domain.model.CoinDetail
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading())
            emit(Resource.Success(
                data = repository.getCoinById(coinId).toCoinDetail())
            )

        } catch (he: HttpException) {

            emit(Resource.Error(he.localizedMessage ?: "An unexpected error occurred"))

        } catch (ioe: IOException) {
            emit(Resource.Error("Cannot reach server, check your network connection"))
        }

    }
}