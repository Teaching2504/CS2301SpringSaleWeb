function deleteProduct(url){
    if(confirm("Bạn chắc chắn xóa không?")==true){
        fetch(url, {
            method:'delete'
        }).then(res =>{
            if(res.status === 204)
                location.reload();
            else{
                alert("Hệ thống có lỗi! Vui lòng quay lại sau!");
            }
        });
    }
}

