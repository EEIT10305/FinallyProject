$('#memberUpdateInfoOneKeyInput').click(function(){

$('#inputName').val("");
$('#inlineRadio1').prop("checked",false);
$('#inlineRadio2').prop("checked",false);
$('#inputPhone').val("");
$('#inputAddress').val("");

$('#inputName').val("王大強");
$('#inlineRadio2').prop("checked",true);
$('#inputPhone').val("0919001900");
$('#inputAddress').val("新北市永和區永和路100號60樓");
});




$('#memberClickUpdatePasswordOneKeyInput').click(function(){

$('#memberInputOldPassword').val("");
$('#memberInputNewPassword').val("");
$('#memberInputCheckPassword').val("");

$('#memberInputOldPassword').val("Do!NG123");
$('#memberInputNewPassword').val("Do!321NG1");
$('#memberInputCheckPassword').val("Do!321NG1");
});