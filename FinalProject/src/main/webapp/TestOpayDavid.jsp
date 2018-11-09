<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
aioCheckOutOneTime: <form id="allPayAPIForm" action="https://payment-stage.opay.tw/Cashier/AioCheckOut/V4" method="post"><input type="hidden" name="ChooseSubPayment" value=""><input type="hidden" name="Redeem" value="Y"><input type="hidden" name="HoldTradeAMT" value="0"><input type="hidden" name="MerchantID" value="2000132"><input type="hidden" name="ClientBackURL" value=""><input type="hidden" name="TotalAmount" value="50"><input type="hidden" name="OrderResultURL" value=""><input type="hidden" name="InvoiceMark" value="N"><input type="hidden" name="IgnorePayment" value=""><input type="hidden" name="UseRedeem" value="N"><input type="hidden" name="PaymentType" value="aio"><input type="hidden" name="CheckMacValue" value="3E2C5B49155EBEFEB2650F4B4E00421029CDBC514C89D9A029B25DFA82F78BC0"><input type="hidden" name="NeedExtraPaidInfo" value="N"><input type="hidden" name="ItemURL" value=""><input type="hidden" name="DeviceSource" value=""><input type="hidden" name="EncryptType" value="1"><input type="hidden" name="TradeDesc" value="test Description"><input type="hidden" name="ChoosePayment" value="Credit"><input type="hidden" name="StoreID" value=""><input type="hidden" name="Remark" value=""><input type="hidden" name="PlatformID" value=""><input type="hidden" name="ReturnURL" value="http://localhost:8081/FinalProject/FirstPage.html"><input type="hidden" name="ItemName" value="TestItem"><input type="hidden" name="MerchantTradeNo" value="test2018110704"><input type="hidden" name="MerchantTradeDate" value="2017/01/01 08:05:23"><script language="JavaScript">allPayAPIForm.submit()</script></form>

</body>
</html>