package com.github.kinoamyfx.tushare4j.market;

import com.github.kinoamyfx.tushare4j.CodeUtils;
import com.github.kinoamyfx.tushare4j.TuShareClientTest;
import com.github.kinoamyfx.tushare4j.core.TsDate;
import com.github.kinoamyfx.tushare4j.core.TuShareException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AdjFactorRequestTest {

    @Test
    public void test() throws IOException, TuShareException {
        AdjFactorRequest request = new AdjFactorRequest()
                .tsCode("000001.SZ")
                .tradeDate(null)
                .startDate(TsDate.parse("20190301"))
                .endDate(TsDate.parse("20190331"));

        Assert.assertEquals("000001.SZ", request.tsCode());
        Assert.assertNull(request.tradeDate());
        Assert.assertEquals(TsDate.of(2019, 3, 1), request.startDate());
        Assert.assertEquals(TsDate.of(2019, 3, 31), request.endDate());

        CodeUtils.assertDataMethod(request);

        List<AdjFactor> call = TuShareClientTest.client.call(request);

        CodeUtils.assertFields(call, Collections.emptyList());
    }
}