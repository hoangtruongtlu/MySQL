<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table class="table table-bordered">
                <thead>
                    <tr>
                    	<th>STT</th>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Phone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
           </table>
		<form name="formInput">
			<input type="hidden" name="stt">

			<p> <b>Tên VXL:</b> </p>
			<input type="text" name="ten">

			<p> <b>Hãng:</b> </p>
			<input type="text"  name="hang">

			<p> <b>Ngày ra mắt:</b> </p>
			<input type="text"  name="ngay">
			
			<p> <b>Giá:</b> </p>
			<input type="text"  name="gia"> <br>
			 
			<button >Thêm</button>
			<button>Hủy</button>
		</form>
</body>
</html>