jQuery(function () {
    //异步加载下拉列表数据
    //加载APP状态数据
    jQuery.getJSON("dataDic/status", function (data) {
        var select = jQuery("#statusValue").val();
        for (var i = 0; i < data.length; i++) {
            //getSelected(select,data[i].valueId) 调用该方法来判断是否进行selected操作
            var option = $("<option value='" + data[i].valueId + "'"
                + getSelected(select, data[i].valueId) + ">" + data[i].valueName + "</option>");
            jQuery("#status").append(option);
        }
        //加载从c层传来的值 不可使用该方法进行select赋值 需要在for循环中进行判断,加入selected属性
        // jQuery("#status").val(jQuery("#statusValue").val());
    })

    //判断选中 selectValue:选中的value值 dataValue:进行判断的value值
    function getSelected(selectValue, dataValue) {
        var selected = selectValue == dataValue ? "selected" : "";
        return selected;
    }

    //加载所属平台数据
    jQuery.getJSON("dataDic/flatformId", function (data) {
        for (var i = 0; i < data.length; i++) {
            var option = $("<option value='" + data[i].valueId + "'"
                + getSelected(jQuery("#flatformIdValue").val(), data[i].valueId) + ">" + data[i].valueName + "</option>");
            jQuery("#flatformId").append(option);
        }
    })
    //加载一级分类
    jQuery.getJSON("category/getList/0", function (data) {
        for (var i = 0; i < data.length; i++) {
            var option = $("<option value='" + data[i].id + "'"
                + getSelected(jQuery("#categoryLevel1Value").val(), data[i].id) + ">" + data[i].categoryName + "</option>");
            jQuery("#categoryLevel1").append(option);
        }
    });
    //一级下拉列表选择改变事件
    jQuery("#categoryLevel1").change(function () {
        //判断是否选中parent分类
        var parentId = jQuery(this).val();
        //是否选中都清空三级分类中的下拉项
        jQuery("#categoryLevel3").html("");
        if (parentId == -1) {
            //清空child下拉列表
            jQuery("#categoryLevel2").html("");
        } else {
            //若不为空,异步加载child下拉列表
            jQuery("#categoryLevel2").html("<option value='-1'>-请选择-</option>");
            jQuery.getJSON("category/getList/" + parentId, function (data) {
                for (var i = 0; i < data.length; i++) {
                    var option = $("<option value='" + data[i].id + "'>" + data[i].categoryName + "</option>");
                    jQuery("#categoryLevel2").append(option);
                }
            })
        }
    })
    //二级下拉列表改变事件
    jQuery("#categoryLevel2").change(function () {
        //判断是否选中parent分类
        var parentId = jQuery(this).val();
        if (parentId == -1) {
            //清空child下拉列表
            jQuery("#categoryLevel3").html("");
        } else {
            //若不为空,异步加载child下拉列表
            jQuery("#categoryLevel3").html("<option value='-1'>-请选择-</option>");
            jQuery.getJSON("category/getList/" + parentId, function (data) {
                for (var i = 0; i < data.length; i++) {
                    var option = $("<option value='" + data[i].id + "'>" + data[i].categoryName + "</option>");
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
        if (categoryValue.val() != null && categoryValue.val() != "" && categoryValue.val() != -1) {
            category.html("<option value='-1'>-请选择-</option>");
            jQuery.getJSON("category/getList/" + parentValue.val(), function (data) {
                for (var i = 0; i < data.length; i++) {
                    var option = $("<option value='" + data[i].id + "'"
                        + getSelected(categoryValue.val(), data[i].id) + ">" + data[i].categoryName + "</option>");
                    category.append(option);
                }
            })
        }
    }

    //点击操作按钮,显示下拉列表
    jQuery(".optionsButton").click(function () {
        jQuery(this).next().toggle();
    })

    //上一页,下一页,首页,末页点击事件
    jQuery("body").on("click", "#firstPage", function () {
        jQuery("#currentPageNo").val(1);
        jQuery("form").submit(); //提交表单 无法使用location.href进行重定向 ,若重定向,则都为null
    }).on("click", "#prevPage", function () {
        jQuery("#currentPageNo").val(-1 + parseInt(jQuery("#currentPageNo").val()));
        jQuery("form").submit();
    }).on("click", "#nextPage", function () {
        jQuery("#currentPageNo").val(1 + parseInt(jQuery("#currentPageNo").val()));
        jQuery("form").submit();
    }).on("click", "#endPage", function () {
        jQuery("#currentPageNo").val(jQuery("#pagesCount").val());
        jQuery("form").submit();
    })
        //修改版本按钮点击事件
        .on("click", ".editVersionButton", function () {
            //判断状态
            var statusName = jQuery(this).parents("tr").find(".statusName").text(); //获取状态名
            if (statusName == "已上架") {
                alert("该商品状态为[已上架],不可修改版本信息");
                return;
            }
            //判断是否存在版本列表
            var appId = jQuery(this).parents("tr").find(".appId").val(); //获取app编号
            jQuery.getJSON("version/versionCount/" + appId, function (data) {
                if (data.count == 0) {
                    alert("该商品暂无版本信息,请先[添加版本]");
                } else {
                    location.href = "version/versionModifyPage/" + appId;
                }
            })
        })
        //删除按钮事件(异步)
        .on("click",".deleteAppButton",function(){
            //询问是否删除
            if(confirm("是否删除该App信息?")){
                var appId = jQuery(this).parents("tr").find(".appId").val(); //获取app编号
                jQuery.getJSON("appInfo/delete/"+appId,function(data){
                    if(data.result=="true"){
                        //重新查询
                        location.href = "appInfo/appInfoList";
                    }else{
                        alert("系统繁忙,删除失败!")
                    }
                })
            }
        })
        //上架按钮事件(异步)
        .on("click",".upApp",function(){
            //询问是否上架
            if(confirm("是否将该App上架?")){
                var appId = jQuery(this).parents("tr").find(".appId").val(); //获取app编号
                jQuery.getJSON("appInfo/modifyStatus?id="+appId+"&status=4",function(data){
                    if(data.result=="true"){
                        //重新查询
                        location.href = "appInfo/appInfoList";
                    }else{
                        alert("系统繁忙,上架失败!")
                    }
                })
            }
        })
        //下架按钮事件(异步)
        .on("click",".downApp",function(){
            //询问是否下架
            if(confirm("是否将该App下架?")){
                var appId = jQuery(this).parents("tr").find(".appId").val(); //获取app编号
                jQuery.getJSON("appInfo/modifyStatus?id="+appId+"&status=5",function(data){
                    if(data.result=="true"){
                        //重新查询
                        location.href = "appInfo/appInfoList";
                    }else{
                        alert("系统繁忙,下架失败!")
                    }
                })
            }
        })
        //审核按钮
        .on("click",".examineButton",function(){
            //判断是否存在版本列表
            var appId = jQuery(this).parents("tr").find(".appId").val(); //获取app编号
            jQuery.getJSON("version/versionCount/" + appId, function (data) {
                if (data.count == 0) {
                    alert("该商品暂无版本信息,无法审核");
                } else {
                    location.href = "backendUser/appExamine/" + appId;
                }
            })
        })

    //加载从c层传来的值 不可使用方法,因为下拉列表使用异步实现,需要在回调函数中进行赋值的操作
    // function loadValue(){
    //     jQuery("#status").val(jQuery("#statusValue").val());
    //     jQuery("#flatformId").val(jQuery("#flatformIdValue").val());
    //     jQuery("#categoryLevel1").val(jQuery("#categoryLevel1Value").val());
    //     jQuery("#categoryLevel2").val(jQuery("#categoryLevel2Value").val());
    //     jQuery("#categoryLevel3").val(jQuery("#categoryLevel3Value").val());
    // }
    //二三级分类加载方法(出现重复问题 异步加载时加载次数有问题 未解决)
    // function loadCategory(parent, child){
    //     jQuery("#"+parent).change(function(){
    //         //判断是否选中parent分类
    //         var parentId = jQuery(this).val();
    //         if (parentId == -1){
    //             //清空child下拉列表
    //             jQuery("#"+child).html("");
    //         }else{
    //             //若不为空,异步加载child下拉列表
    //             jQuery("#"+child).html("<option value='-1'>-请选择-</option>");
    //             jQuery.getJSON("category/getList/"+parentId,function(data){
    //                 for (var i = 0 ; i < data.length ; i++){
    //                     var option = $("<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>");
    //                     jQuery("#"+child).append(option);
    //                 }
    //             })
    //         }
    //     })
    // }
})