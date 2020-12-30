jQuery(function(){

    // jQuery("#addForm").validate({
    //     rules:{
    //         flatformId:{required:true, min:0}
    //     }
    // })

    jQuery("#backButton").click(function(){
        location.href = "appInfo/appInfoList"
    })

    //加载所属平台数据
    jQuery.getJSON("dataDic/flatformId",function(data){
        for (var i = 0 ; i < data.length ; i++){
            var option = $("<option value='"+data[i].valueId+"'>"+data[i].valueName+"</option>");
            jQuery("#flatformId").append(option);
        }
    })
    //加载一级分类
    jQuery.getJSON("category/getList/0",function(data){
        for (var i = 0 ; i < data.length ; i++){
            var option = $("<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>");
            jQuery("#categoryLevel1").append(option);
        }
    });
    //一级下拉列表选择改变事件
    jQuery("#categoryLevel1").change(function(){
        //判断是否选中parent分类
        var parentId = jQuery(this).val();
        //是否选中都清空三级分类中的下拉项
        jQuery("#categoryLevel3").html("");
        if (parentId == -1){
            //清空child下拉列表
            jQuery("#categoryLevel2").html("");
        }else{
            //若不为空,异步加载child下拉列表
            jQuery("#categoryLevel2").html("<option value='-1'>-请选择-</option>");
            jQuery.getJSON("category/getList/"+parentId,function(data){
                for (var i = 0 ; i < data.length ; i++){
                    var option = $("<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>");
                    jQuery("#categoryLevel2").append(option);
                }
            })
        }
    })
    //二级下拉列表改变事件
    jQuery("#categoryLevel2").change(function(){
        //判断是否选中parent分类
        var parentId = jQuery(this).val();
        if (parentId == -1){
            //清空child下拉列表
            jQuery("#categoryLevel3").html("");
        }else{
            //若不为空,异步加载child下拉列表
            jQuery("#categoryLevel3").html("<option value='-1'>-请选择-</option>");
            jQuery.getJSON("category/getList/"+parentId,function(data){
                for (var i = 0 ; i < data.length ; i++){
                    var option = $("<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>");
                    jQuery("#categoryLevel3").append(option);
                }
            })
        }
    })
})