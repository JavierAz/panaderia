$(document).ready(function () {
    $("tr #btnDelete").click(function () {
        const idp = $(this).parent().find("#idp").val();
        swal({
            title: "Esta seguro?",
            text: "realmente desea eliminarlo?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
            .then((willDelete) => {
                if (willDelete) {
                    eliminar(idp);
                    swal("Se elimino!", {
                        icon: "success",
                    }).then((willDelete)=>{
                        if(willDelete){
                            parent.location.href="ProductsServlet?action=Cart";
                        }
                    });
                } else {
                    swal("Producto no eliminado");
                }
            });

    });

    function eliminar(idp) {
        var url = "ProductsServlet?action=Delete";
        //console.log(url, idp)
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success: function (data, textStatus, jqXHR) {
                alert("Eliminado");
            }
        })
    }
});