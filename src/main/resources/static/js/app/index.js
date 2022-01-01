var main = {
    init: function () {
        var _this = this;

        $('#btn-save').on('click', function () {
        _this.save();
        });

        $('#btn-update').on('click', function () {
        _this.update();
        });

        $('#btn-delete').on('click', function () {
        _this.deleted();
        });

     },
     save: function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록 되었습니다.');
            window.location.href='/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
     },
     update: function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val(); //url에 사용하기위해

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts/'+id,//@PostMapping("/api/v1/posts/{id}")
                                     //url시작에 /안붙이면 http://localhost:8080/posts/update/api/v1/posts/
            dataType: 'json',        //@RequestBody PostsUpdateRequestDto requestDto)
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href='/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
     },
     deleted: function() {
         var id = $('#id').val();

         $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
         }).done(function() {
            alert('글이 삭제되었습니다.');
         }).fail(function (error) {
            alert(JSON.stringify(error));
         });

     }

};

main.init();