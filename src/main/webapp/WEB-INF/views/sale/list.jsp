<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 조회</title>

<style>
	.nav {
	    display: flex;
	    align-items: center;
	    justify-content: center;
	    width: 100%;
	    height: 80px;
	    border: 1px solid #ccc;
	    border-radius: 30px;
	}
	.show_nav {
	    display: flex;
	    align-items: center;
	    justify-content: flex-start;
	    width: 95%;
	    height: 50%;
	}
	.show_title {
	    font-size: 20px;
	    font-weight: bolder;
	    margin-left: 10px;
	    font-family: Arial, sans-serif;
	}
	.show_select {
	    display: flex;
	    align-items: center;
	    justify-content: space-evenly;
	    width: 40%;
	}
	.select_box {
	    display: flex;
	    align-items: center;
	    justify-content: center;
	    border-radius: 30px;
	    padding: 5px;
	    font-size: 14px;
	    width: 80px;
	    background-color: #b0dbef;
	    font-family: Arial, sans-serif;
	    cursor: pointer;
	}
	.show_search {
	    display: flex;
	    align-items: center;
	    justify-content: flex-end;
	    width: 50%;
	}
	input {
	    padding: 5px;
	    border: #ccc;
	    border-radius: 5px;
	    background: #ccc;
	    text-align: center;
	}
	button {
	    padding: 5px;
	    border: none;
	    border-radius: 5px;
	    background-color: #007bff;
	    color: #fff;
	    font-size: 14px;
	    cursor: pointer;
	}
	.table_area {
	    border: 1px solid #000; 
	    width: 100%;
	    text-align: center;
	    display: flex;
	    justify-content: center;
	    margin-top: 30px;
	}
	.table_area table {
	    width: 100%;
	    border-collapse: collapse;
	    text-align: center;
	    font-family: Arial, sans-serif;
	    font-size: 14px;
	    color: #333;
	}
	
	.table_area table thead th {
	    background-color: #f4f4f4;
	    border: 1px solid #ddd;
	    padding: 10px;
	    font-weight: bold;
	}
	
	.table_area table tbody td {
	    border: 1px solid #ddd;
	    padding: 8px;
	}
	
	.table_area table tbody tr:nth-child(odd) {
	    background-color: #fafafa;
	}
	
	.table_area table tbody tr:nth-child(even) {
	    background-color: #ffffff;
	}
	
	.table_area table tbody tr:hover {
	    background-color: #f1f1f1;
	    cursor: pointer;
	}
	
	.footer {
	    display: flex;
	    align-items: center;
	    justify-content: flex-start;
	    width: 100%;
	    height: 30px;
	    color: #333;
	    text-align: center;
	    font-size: 14px;
	    margin-top: 30px;
	    padding: 7px;
	}

	.footer_menu {
	    display: flex;
	    justify-content: space-between;
	    width: 30%;
	    padding: 5px;
	    border: 1px solid #ccc;
	    border-radius: 10px;
	    background-color: #ccc;
	}
</style>

</head>
<body>
    <div class="nav"> 
        <div class="show_nav">
            <div class="show_title">판매조회</div>
            <div class="show_select">
                <div class="select_box">전체</div>
                <div class="select_box">결재중</div>
                <div class="select_box">미확인</div>
                <div class="select_box">확인</div>
            </div>
            <div class="show_search">
                <div class="search_main">
                    <input type="text" placeholder="입력 후 [Enter]">
                    <button>Search</button>
                </div>
            </div>
        </div>
    </div>
    <div class="table_area">
        <table>
            <thead>
                <tr>
                	<th><input type="checkbox" id="selectAll"></th>
                    <th>일자</th>
                    <th>거래처명</th>
                    <th>품목명</th>
                    <th>금액합계</th>
                    <th>거래유형명</th>
                    <th>출하창고명</th>
                </tr>
            </thead>
            <c:forEach items="${ list }" var="sale">
	            <tbody>
	                <tr>
		                <th><input type="checkbox" id="selectOne"></th>
	                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${ sale.createdAt }" /></td>
	                    <td><c:out value="${ sale.tradeName }" /></td>
	                    <td><c:out value="${ sale.productName }" /></td>
	                    <td><c:out value="${ sale.priceSum }" /></td>
	                    <td><c:out value="${ sale.type }" /></td>
	                    <td><c:out value="${ sale.warehouseName }" /></td>
	                </tr>
	            </tbody>
            </c:forEach>
        </table>
    </div>
    <div class="footer">
        <div class="footer_menu">
            <button>신규</button>
            <button>인쇄</button>
            <button>선택삭제</button>
        </div>
    </div>
</body>
<script type="text/javascript">
    // selectAll 체크박스 클릭 시 모든 selectOne 체크박스 선택/해제
    document.getElementById('selectAll').addEventListener('change', function () {
        const isChecked = this.checked;
        const checkboxes = document.querySelectorAll('#selectOne');
        checkboxes.forEach(checkbox => checkbox.checked = isChecked);
    })
    
    // 선택 삭제 버튼 클릭 시 선택된 행 삭제
    document.querySelector('.footer_menu button:nth-child(3)').addEventListener('click', function () {
        const checkboxes = document.querySelectorAll('#selectOne:checked');
        if (checkboxes.length === 0) {
            window.alert("삭제할 행을 선택하세요.");
            return;
        }
        
        // 선택된 행의 ID 수집
        checkboxes.forEach(checkbox => {
            const row = checkbox.closest('tr');
            row.remove(); // UI에서 행 삭제
        });
        
        // 서버로 삭제 요청 보내기
        fetch('/deleteSales', {
        	method: 'POST',
        	headers: {
        		'Content-Type': 'application/json'
        	},
        	body: JSON.stringify({ ids: ids }) // 선택된 ID를 JSON 형식으로 전달
        })
        .then(response => response.json())
        .then(data => {
        	if (data.success) {
        		alert("선택된 행이 삭제 되었습니다.");
        	} else {
        		alert("삭제 중 오류가 발생했습니다.");
        	}
        })
        .catch(error => 
        	console.error('Error: ', error);
        	alert("서버와 통신 중 문제가 발생했습니다.");
        })
    })
</script>
</html>