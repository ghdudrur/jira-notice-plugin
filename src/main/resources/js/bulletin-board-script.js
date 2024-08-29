
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
        AJS.dialog2("#dialog-create-notice").show();
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
            success: function(){
                AJS.dialog2("#dialog-create-notice").hide();
                document.location.reload(true);
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
    AJS.$("#form-dialog-close-button").on('click', function (e) {
        console.log("close >>>>>>>>>>>>>>>>>>>>");
        e.preventDefault();
        AJS.dialog2("#dialog-create-notice").hide();
    });
    AJS.$("#issue-tab-panel-user-selector").val('').auiSelect2();

    AJS.$(".notice-title").on('click', function (e) {
        console.log(">>>>>>>>>>>>>>>", e.target.parentElement.getAttribute("value"));
        document.location.href=AJS.contextPath()+"/projects/TEST?selectedItem=dev.jira.jira-notice-plugin:project-notice-update-page&id="+e.target.parentElement.getAttribute("value");
    });

    AJS.$(".notice-edit-button").on('click', function (e) {
        console.log(">>>>>>>>>>>>>>>", AJS.$(e.target).closest("tr").attr("value"));
        document.location.href=AJS.contextPath()+"/projects/TEST?selectedItem=dev.jira.jira-notice-plugin:project-notice-update-page&id="+AJS.$(e.target).closest("tr").attr("value");
    });

    AJS.$(".notice-delete-button").on('click', function (e) {
        console.log(">>>>>>>>>>>>>>> delete");
        e.preventDefault();
        AJS.$.ajax({
            url: AJS.contextPath() + "/rest/notice/1.0/delete?id=" +  AJS.$(e.target).closest("tr").attr("value"),
            contentType : 'application/json; charset=utf-8',
            type: "DELETE",     
            success: function(){
               document.location.reload(true);
               //location.replace(AJS.contextPath()+"/projects/TEST?selectedItem=dev.jira.jira-notice-plugin:project-notice-page");
            }
        });
    });

    
});

