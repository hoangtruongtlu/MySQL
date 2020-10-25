$(function() {
    $(".header").load("header.html");
    $(".main").load("main.html"); 
    $(".footer").load("footer.html"); 
    $(".main").load("home.html"); 
    showData();
});

function clickNavHome(){
    $(".main").load("home.html");
    showData();
}

function clickNavViewList(){
    $(".main").load("viewlist.html");
    initTable();
}


var employees = [];
var counter = 0;

function Employee(name,department,phone){
    this.id = ++counter;
    this.name = name;
    this.department = department;
    this.phone = phone;
}
function initEmployees(){
    if(null == employees || employees.length == 0) {
        employees.push(new Employee("Chaya Lubowitz", "Electronics", "(022) 666-9855"));
        employees.push(new Employee("Amalia Crist", "Beauty", "(374) 684-6786"));
        employees.push(new Employee("Mrs. Catalina Daugherty", "Industrial", "1-852-503-9273 x088"));
        employees.push(new Employee("Delpha Beahan", "Jewelery", "1-176-317-4299 x89075"));
    }
}
function initTable(){
    setTimeout(function name(params){
        $('tbody').empty();

        initEmployees();

        employees.forEach(function(item){
            $('tbody').append(
                '<tr>'
                    + '<td>' + item.name + '</td>'
                    + '<td>' + item.department + '</td>'
                    + '<td>' + item.phone + '</td>'
                    + '<td>' +
                        '<a class="edit" title="Edit" data-toggle="tooltip" onclick = "openUpdateModal('+item.id+')"><i class="material-icons">&#xE254;</i></a>' +
                        '<a class="delete" title="Delete" data-toggle="tooltip" onclick = "openConfirmDelete('+item.id+')"><i class="material-icons">&#xE872;</i></a>' +
                    '</td>' +
                '</tr>')
        });
    }, 500);
}

function openAddModal(){
    showModal();
    resetFrom(); 
}

function showModal(){
    $('#myModal').modal('show');
}

function hideModal(){
    $('#myModal').modal('hide');
}

function resetFrom(){
    // document.getElementById("id").value= "";
    document.getElementById("name").value= "";
    document.getElementById("department").value= "";
    document.getElementById("phone").value= "";
}
function addEmployee(){

    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    employees.push(new Employee(name, department, phone));

    hideModal();
    initTable();
    showSuccessAlert();
}

function openUpdateModal(id){
    var index = employees.findIndex(x => x.id == id);

    document.getElementById("id").value= employees[index].id;
    document.getElementById("name").value= employees[index].name;
    document.getElementById("department").value= employees[index].department;
    document.getElementById("phone").value= employees[index].phone;

    showModal();
}

function save(){
    var id = document.getElementById("id").value;
    if(id == null || id == "") {
        addEmployee();
    }
    else{
        updateEmployee();
    }
}

function updateEmployee(){

    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    var index = employees.findIndex(x => x.id==id);
    employees[index].name = name;
    employees[index].department = department;
    employees[index].phone = phone;


    hideModal();
    initTable();
    showSuccessAlert();
}

function showSuccessAlert(){
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
        $("#success-alert").sildeUp(500);
    });
}

function openConfirmDelete(id){
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id){
    var index = employees.findIndex(x => x.id==id);
    employees.splice(index,1);
}

function showData(){
        $.get("https://5f8d9c4c4c15c40016a1df3f.mockapi.io/employees",function(data,status){
                employees = [];
                parseData(data);
                fillStudentIntoTable();
        });

        function parseData(data){
            data.forEach(function(item) {
                employees.push(new Employee(item.name,item.department,item.phone));
            });
        }
        function fillStudentIntoTable(){
            employees.forEach(function(item){
                $("tbody").append(
                    "<tr id =\"" + item.id+"\">"+
                        "<td>"+item.name+"</td>" +
                        "<td>"+item.department+"</td>" +
                        "<td>"+item.phone+"</td>"+
                    "</tr>"
                )
            })
        }
}