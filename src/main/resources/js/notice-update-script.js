
console.log("start >>>>>>>>>>>>>>>>>>>>");
AJS.toInit(function(){
    AJS.$("#custom-parser-example").removeClass("aui-table-sortable");
    AJS.$("#custom-parser-example").addClass("aui-table-sortable");
    AJS.tablessortable.setTableSortable(AJS.$("#custom-parser-example"));
    AJS.$("#custom-parser-example").show();
    console.log("middle 1 >>>>>>>>>>>>>>>>>>>>");

    AJS.$("#notice-add-button").on('click', function(e) {
        console.log("notice-add-button>>>>>>>>>>>>>>>>>>>>");
        e.preventDefault();
        AJS.dialog2("#demo-dialog").show();
    });

    AJS.$("#create-notice-button").on('click', function(e) {
        console.log("create-notice-button>>>>>>>>>>>>>>>>>>>>");
        e.preventDefault();
        let data = {"subject" : AJS.$("#create-notice-subject").val()
                    , "context" : AJS.$("#create-notice-context").val()
                    }
        AJS.$.ajax({
            url: AJS.contextPath() + "/rest/notice/1.0/create",
            contentType : 'application/json; charset=utf-8',
            type: "POST",
            data: JSON.stringify(data),
            success: function(msg){
              alert(msg);
            }
          });
    });
    
    AJS.$("#update-bulletin-button").on('click', function(e) {
        e.preventDefault();
        AJS.location("http://localhost:2990/jira/projects/TEST?selectedItem=dev.jira.jira-notice-plugin:project-notice-update-page");
    });
    AJS.$(document).ready(function() {
        AJS.$('#demo-range-2').datePicker({'overrideBrowserDefault': true});
    });
    // Hides the dialog
    AJS.$("#dialog-submit-button").on('click', function (e) {
        e.preventDefault();
        AJS.dialog2("#demo-dialog").hide();
    });
    
    AJS.$("#form-dialog-close-button").on('click', function (e) {
        console.log("close >>>>>>>>>>>>>>>>>>>>");
        e.preventDefault();
        AJS.dialog2("#demo-dialog").hide();
    });
    AJS.$("#issue-tab-panel-user-selector").val('').auiSelect2();

    AJS.$(".notice-title").on('click', function (e) {
        console.log(">>>>>>>>>>>>>>>", e.target.parentElement.getAttribute("value"));
        document.location.href=AJS.contextPath()+"/projects/TEST?selectedItem=dev.jira.jira-notice-plugin:project-notice-update-page&id="+e.target.parentElement.getAttribute("value");
    });
});





AJS.$("#update-complete-button").on('click', function (e) {
    console.log("update >>>>>>>>>>>>>>>>>>>>>>");
    e.preventDefault();
    
});



