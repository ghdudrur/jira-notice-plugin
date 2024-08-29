
console.log("start >>>>>>>>>>>>>>>>>>>>");
AJS.toInit(function(){
    
    console.log("middle 1 >>>>>>>>>>>>>>>>>>>>");

    AJS.$(document).ready(function() {
        AJS.$('#date-picker-for-notice').datePicker({'overrideBrowserDefault': true});
    });

    AJS.$("#update-notice-complete-button").on('click', function (e) {
        console.log("update >>>>>>>>>>>>>>>>>>>>>>");
        e.preventDefault();
        let data = {"subject" : AJS.$("#update-notice-subject").val()
                    , "context" : AJS.$("#update-notice-context").val()
                    }
        AJS.$.ajax({
            url: AJS.contextPath() + "/rest/notice/1.0/update?id=" + AJS.$('#notice-board-update-form').data('noticeid'),
            contentType : 'application/json; charset=utf-8',
            type: "POST",
            data: JSON.stringify(data),     
            success: function(){
                onbeforeunload = function(){}
                location.replace(AJS.contextPath()+"/projects/TEST?selectedItem=dev.jira.jira-notice-plugin:project-notice-page");
            }
        });
    });

    AJS.$(".notice-delete-button2").on('click', function (e) {
        console.log(">>>>>>>>>>>>>>> delete >>>>" + AJS.$("#notice-board-update-form").data('noticeid'));
        e.preventDefault();
        AJS.$.ajax({
            url: AJS.contextPath() + "/rest/notice/1.0/delete?id=" +  AJS.$("#notice-board-update-form").data('noticeid'),
            contentType : 'application/json; charset=utf-8',
            type: "DELETE",     
            success: function(){
               //document.location.reload(true);
               location.replace(AJS.contextPath()+"/projects/TEST?selectedItem=dev.jira.jira-notice-plugin:project-notice-page");
            }
        });
    });
});






