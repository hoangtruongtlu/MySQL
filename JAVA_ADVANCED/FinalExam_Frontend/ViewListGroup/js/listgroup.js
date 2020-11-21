function openListGroup(){
    $(".main-content").load("list-group.html");
    builtTable();
}

var groups = [];

function Group(id, name, member, creator, createDate){
    this.id = id;
    this.name = name;
    this.member = member;
    this.creator = creator;
    this.createDate = createDate;
}
var page = 1;
    size = 5;
    type = "";
    field = "";
    keyword = "";
    from = -1 ;
    to = -1;

function initGroups(){
    //init data
    $.get("http://localhost:8080/api/v1/groups?page=" + page + "&size=" + size+ "&sortType=" + type
    + "&sortField=" + field + "&search=" + keyword + "&from=" + from+ "&to=" + to, function(data,status){
        
        // reset list groups
        groups = [];

        // error
        // if (status == "error") {
        //     // TODO
        //     alert("Error when loading data");
        //     return;
        // }
        $('tbody').empty();
        // success
        parseData(data);
        fillGroupToTable();
    });
}

function parseData(data) {
    groups = [];
    console.log(data);
    data.forEach(function(item) {
        groups.push(new Group(item.groupId, item.groupName, item.totalMember, item.creator, item.createDate));
    });
}

function fillGroupToTable(){
    var stt = 1;
    $('tbody').empty();
    groups.forEach(function(item){
        if(stt%2==0){
            $('tbody').append(
            '<tr>'+
                '<td><input type="checkbox" name="idGroup" value="'+ item.id +'"></td>'+
                '<td>' + item.id + '</td>'+
                '<td><a href="#" onclick="openGroupDetail('+ item.id +')">' + item.name + '</a></td>'+  
                '<td>' + item.member + '</td>'+
                '<td>' + item.creator + '</td>'+
                '<td>' + convertExpandedDateToDate(item.createDate) + '</td>'+
            '</tr>')
        }
        else{
            $('tbody').append(
            '<tr style="background-color: lightgray;">'+
                '<td><input type="checkbox" name="idGroup" value="'+ item.id +'"></td>'+
                '<td>' + item.id + '</td>'+
                '<td><a href="#" onclick="openGroupDetail('+ item.id +')">' + item.name + '</a></td>'+
                '<td>' + item.member + '</td>'+
                '<td>' + item.creator + '</td>'+
                '<td>' + convertExpandedDateToDate(item.createDate) + '</td>'+
            '</tr>')
        }
        stt++;
    });
}

function builtTable() {
    // $('tbody').empty();
    initGroups();
}

function builtTableNull(){
    setTimeout(function name(params){
        $('tbody').empty();
        $('tbody').append(
        '<tr style="background-color: lightgray;">'+
            '<td><input type="checkbox" name="idGroup"></td>'+
            '<td></td>'+
            '<td></td>'+
            '<td></td>'+
            '<td></td>'+
            '<td></td>'+
        '</tr>');
    }, 300)
}

function openAddModal(){
    resetForm();
    showModal();
}

function resetForm(){
    document.getElementById("name").value = "";
    document.getElementById("member").value = "";
    document.getElementById("creator").value = "";
}

function showModal(){
    $('#myModal').modal('show');
}

function hideModal(){
    $('#myModal').modal('hide');
}

function convertExpandedDateToDate(exDate){
    var date = new Date(exDate);
    var dd = exDate.slice(8,10);
    var mm = date.getMonth()+1;      //As January is 0.
    var yyyy = date.getFullYear();

    if(mm<10) mm='0'+mm;
    return dd+'/'+mm+'/'+yyyy;
}

function convertDateToExpandedDate(date){
    // var date = new Date(date1);
    var dd = date.getDate();
    var mm = date.getMonth()+1;      //As January is 0.
    var yyyy = date.getFullYear();
    var HH = date.getHours();
    var MM = date.getMinutes();
    var SS = date.getSeconds();
    var MLS = date.getMilliseconds();

    if(dd<10) dd='0'+dd;
    if(mm<10) mm='0'+mm;
    if(HH<10) HH='0'+HH;
    if(MM<10) MM='0'+MM;
    if(SS<10) SS='0'+SS;
    if(MLS<10) MLS='00'+MLS
    else if(MLS<100) MLS='0'+MLS;

    return yyyy+'-'+mm+'-'+dd+'T'+HH+':'+MM+':'+SS+'.'+MLS+'Z';
}

function addGroup(){
    var name = document.getElementById("name").value;
    var member = document.getElementById("member").value;
    var creator = document.getElementById("creator").value;
    if(name != "" && member != "" && creator != ""){
        if(checkNameGroup(name)){
            if(member>=0){
                var today = new Date();

                var group = {
                    name: name,
                    member: member,
                    creator: creator,
                    createDate: convertDateToExpandedDate(today),
                };
            
                $.post("", group,
                    function(data, status) {
                        // error
                        if (status == "error") {
                            alert("Error when loading data");
                            return;
                        }
            
                        // success
                        hideModal();
                        showSuccessAlert();
                        builtTable();
                    });
            }
            else alert("Member: Cannot enter negative numbers!");
        }
        else{
            alert("Group name is exists. Enter another name!");
        }
    }
    else{
        alert("Please fill out the form");
    }
}

function checkNameGroup(name){
    var index = 0;
    var check = false;
    // index = groups.findIndex(x => x.name.localeCompare(name));

    groups.forEach(function(item){
        if(item.name.localeCompare(name) == 0){
            index += 1;
        }
    })
    if (index == 0){
        check = true;
    }
    return check;
}

function openDeleteConfirm(){
    var checkbox = document.getElementsByName('idGroup');
    var result = [];
    var names = [];    

    // Lặp qua từng checkbox để lấy giá trị
    for (var i = 0; i < checkbox.length; i++){
        if (checkbox[i].checked === true){
            result.push(checkbox[i].value);  //Get ID từng checkbox
            var index = groups.findIndex(x => x.id == checkbox[i].value);
            names.push(groups[index].name);
        }
    }

    var result1 = confirm("Are you sure to delete " + names.toString() + " ?");
    if (result1) {
        deleteGroup(result);
    }
}

function deleteGroup(ids){
    // var countGroup = groups.length - ids.length;
    for (var i = 0; i < ids.length; i++){
        var id = ids[i];
        $.ajax({
            
            url: "" + id,
            type: 'DELETE',
            success: function(result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }
    
                // success
                showDeleteAlert();
                builtTable();
            }
        });
    }


        // var index = groups.findIndex(x => x.id == result[i]);
        // groups.splice(index,1);
}
    // showDeleteAlert();
    // if(countGroup > 0){
        // builtTable();
    // }
    // else{
    //     builtTableNull();
    // }
// }

function showSuccessAlert(){
    $("#alert-success").fadeTo(2000,500).slideUp(500, function(){
        $("#alert-success").slideUp(500);
    });
}

function showDeleteAlert(){
    $("#alert-danger").fadeTo(2000,500).slideUp(500, function(){
        $("#alert-danger").slideUp(500);
    });
}