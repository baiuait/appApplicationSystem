jQuery(function(){
    //返回按钮
    jQuery("#backButton").click(function(){
        location.href = "appInfo/appInfoList"
    })
    //apk文件删除按钮(修改version页面)
    jQuery("#deleteApkButton").click(function(){
        jQuery("#apkFileName").text("");
        jQuery("input[name='apkFileName']").val("");
        jQuery("input[name='apkLocPath']").val("");
    })
})