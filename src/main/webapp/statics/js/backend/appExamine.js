jQuery(function(){
    //审核通过
    jQuery("#sendOK").click(function(){
        var appId = jQuery("#appId").val();
        location.href = "backendUser/examine/"+appId+"/2";
    })
    //审核不通过
    jQuery("#sendNO").click(function(){
        var appId = jQuery("#appId").val();
        location.href = "backendUser/examine/"+appId+"/3";
    })
    //返回
    jQuery("#backButton").click(function(){
        location.href = "backendUser/appInfoList";
    })
    //加载图片
    jQuery("#logoPic").attr("src",jQuery("#logoLocPath").val());
})