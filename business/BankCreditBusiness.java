package com.bank.credit.gateway.business;

import com.bank.credit.gateway.constants.Constants;
import com.bank.credit.gateway.enums.CharsetEnum;
import com.bank.credit.gateway.enums.SignTypeEnum;
import com.bank.credit.gateway.format.*;
import com.bank.credit.gateway.utils.DateUtil;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BankCreditBusiness {

    public Head getHead(String appId, String function, String reqMsgId, String reverse) {
        Head head = new Head();
        head.setVersion(Constants.SYSTEM_VERSION);
        head.setSignType(SignTypeEnum.RSA.name());
        head.setRespTime(DateUtil.toDate(new Date()));
        head.setInputCharset(CharsetEnum.UTF8.name());
        head.setAppId(appId);
        head.setFunction(function);
        head.setReqMsgId(reqMsgId);
        head.setReverse(reverse);
        return head;
    }

    public Body getBody(String applyNo, String requestId, ResultInfo resultInfo) {
        Body body = new Body();
        body.setApplyNo(applyNo);
        body.setRequestId(requestId);
        body.setResultInfo(resultInfo);
        return body;
    }

    public Response getResponse(Head head, Body body) {
        return new Response(head, body);
    }

    public Document getDocument(Response response, Signature signature) {
        return new Document(response, signature);
    }
}
