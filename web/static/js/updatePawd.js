function check(userPawd) {
    var pawd=$('#pawd').val();
    var repawd=$('#repawd').val();
    if(pawd!=repawd){
        alert("密码不一致")
    }else if(userPawd==pawd){
        alert("请不要输入现在使用的密码");
    }
    else if(repawd.length<5){
        alert('密码过短');
    }else{
        alert('修改成功');
        $('#pwadForm').submit();
    }

}
