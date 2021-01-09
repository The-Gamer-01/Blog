function check() {
    var pawd=$('#pawd').val();
    var repawd=$('#repawd').val();
    if(pawd!=repawd){
        $('#repawdcheck').css('display','inline');
    }
}

function checkAndsend() {
    var name=$('#name').val();
    var telOremail=$('#teloremail').val();
    var time=$('#birthday').val();
    var email=$('#email').val();
    var flag=true;
    var myreg = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
    if(name.length<3){
        flag=false;
        alert('用户名不得小于3');
    }
    if(telOremail==null){
        flag=false;
        alert('请输入联系方式');
    }
    if(time==""){
        flag=false;
        alert('请输入出生日期');
    }
    if(myreg.test(email)){
        flag=false;
        alert('邮箱格式错误');
    }
    if(flag){
        $('#registerForm').submit();
    }
}