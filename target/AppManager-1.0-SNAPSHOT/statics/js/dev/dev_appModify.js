jQuery(function(){
    //加载图片
    jQuery("#logoPic").attr("src",jQuery("#logoLocPath").val());
    //删除图片按钮
    jQuery("#deleteImgButton").click(function(){
        //将图片元素去除掉
        jQuery("#logoPic").remove();
        //将两个路径改为空,在controller层进行修改
        jQuery("#logoLocPath").val("");
        jQuery("#logoPicPath").val("");
    })
    //返回按钮
    jQuery("#backButton").click(function(){
        location.href = "appInfo/appInfoList"
    })
    //保存并再次提交审核
    jQuery("#saveAndSend").click(function(){
        //将状态值改为待审核
        jQuery("#status").val(1);
        //提交表单
        jQuery("form").submit();
    })

    //判断选中 selectValue:选中的value值 dataValue:进行判断的value值
    function getSelected(selectValue, dataValue){
        var selected = selectValue == dataValue ? "selected" : "";
        return selected;
    }

//加载所属平台数据
    jQuery.getJSON("dataDic/flatformId",function(data){
        for (var i = 0 ; i < data.length ; i++){
            var option = $("<option value='"+data[i].valueId+"'"
                +getSelected(jQuery("#flatformIdValue").val(),data[i].valueId)+">"+data[i].valueName+"</option>");
            jQuery("#flatformId").append(option);
        }
    })
//加载一级分类
    jQuery.getJSON("category/getList/0",function(data){
        for (var i = 0 ; i < data.length ; i++){
            var option = $("<option value='"+data[i].id+"'"
                +getSelected(jQuery("#categoryLevel1Value").val(),data[i].id)+">"+data[i].categoryName+"</option>");
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

//若提交前选中,则加载二三级分类
    categoryListLoad(jQuery("#categoryLevel2Value"), jQuery("#categoryLevel1Value"), jQuery("#categoryLevel2"));
    categoryListLoad(jQuery("#categoryLevel3Value"), jQuery("#categoryLevel2Value"), jQuery("#categoryLevel3"));

//加载二三级分类下拉列表
    function categoryListLoad(categoryValue, parentValue, category) {
        if(categoryValue.val() != null && categoryValue.val() != "" && categoryValue.val() != -1){
            category.html("<option value='-1'>-请选择-</option>");
            jQuery.getJSON("category/getList/"+parentValue.val(),function(data){
                for (var i = 0 ; i < data.length ; i++){
                    var option = $("<option value='"+data[i].id+"'"
                        +getSelected(categoryValue.val(),data[i].id)+">"+data[i].categoryName+"</option>");
                    category.append(option);
                }
            })
        }
    }
})