package ru.bulyg.forretech.utils

import ru.bulyg.forretech.mvp.model.Fact
import ru.bulyg.forretech.mvp.model.entity.ResponseInfo

fun mapToFact(info: ResponseInfo) = Fact(
    info.text,
    info.createdAt
)