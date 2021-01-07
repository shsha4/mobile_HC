

if(user == '' || user == null){
    $('#login').modal('show');
}else {
    $('#mask').hide();
    $('#login').modal('hide');
}

//로그인 버튼 클릭시
$('#loginBtn').click(function(e) {
    e.preventDefault();
    //ID, PW 확인 및 공백시 포커싱
    if($('#user').val() == ''){
        $('#user').focus();
        alert("ID를 입력해 주세요.");
        return;
    }else if($('#password').val() == ''){
        $('#password').focus();
        alert("PassWord를 입력해 주세요.");
        return;
    }

    // mat계정 확인후 맞다면 ajax로 세션 생성
    // if($('#user').val() == 'mat' && $('#password').val() == 'mat999'){
    //     $('#mask').hide();
    //     $('#login').modal('hide');
    //
    // }else {
    //     //계정 값이 맞지 않을시 알럿
    //     alert('ID와 Password를 확인해 주십시오.');
    //     $('#mask').show();
    //     $('#login').modal('show');
    // }

    $.ajax({
        type: 'POST',
        url: '/login.do',
        data: {
            'id' : $('#user').val(),
            'pw' : $('#password').val()
        },
        success : (data) => {
            if(data) {
                $('#mask').hide();
                $('#login').modal('hide');
            }
        }
    })

});