<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
        /*上传图像预览的css地下还有js*/
        .img-container{
        	display:inline;
            width: 50px;
            height: 50px;
            overflow: hidden;
            vertical-align: top;
        }
        .img-container>img{
            width: 50px;
            height: 50px;
        }
        .img{
            width: 50px;
            height: 50px;
        }
        /*让头像的input框和后面预览的div水平对齐*/
        .span1,.span2{float: left;display: inline-block;height: 40px;}
        .box{margin: 1px auto;padding: 1px ;}
        .span1{width: 150px;position: relative;}
        .img-btn{border: 0 none;height: 20px;width: 140px;padding: 10px 5px;position: absolute;top: 0;}
        .img-container{height: 40px;font: normal 18px/40px "微软雅黑";}
    </style>
<script language="javascript" type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
</head>
<body>
	<form action="<%=request.getContextPath() %>/teacher_add.do" id="f1" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>姓名</td>
				<td choose='choose'><input type="text" name="teacher.tName" onblur="isExists(this.value)"></td>
			</tr>
			<tr>
				<td>头像</td>
				<td choose='choose'> 
					<div class="box">
				        <span class="span1">
				            <input class="img-btn" type="file" id="drivingLicence" name="file">
				        </span>
				        <span class="span2">
				        	<div class="img-container"></div>
				        </span>
				    </div>
						
					
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td choose='choose'>
					<label for="nan">男</label><input id="nan" type="radio" checked="checked" name="teacher.tSex.dId" value="1">
					<label for="nv">女</label><input id="nv" type="radio" name="teacher.tSex.dId" value="2">
				</td>
			</tr>
			
			<tr>
				<td>工资</td>
				<td choose='choose'><input type="text" name="teacher.tSalary"></td>
			</tr>
			
			<tr>
				<td>身份证号</td>
				<td choose='choose'><input type="text" name="teacher.tIdcard"></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td choose='choose'><input type="text" name="teacher.tAge"></td>
			</tr>
			<tr>
				<td>入职日期</td>
				<td choose='choose'><input type="text" class="Wdate" onclick="WdatePicker()" name="teacher.tStartdate"></td>
			</tr>
			
		</table>
		<input type="submit" value="添加">
	</form>
	
	
	
	 <script>
        /**
         * Created by Administrator on 2016/4/28.
         */
		//上传图片并预览的js
        function previewImg(fileInput,imgDiv){
            if(window.FileReader){//支持FileReader的时候
                var reader=new FileReader();
                reader.readAsDataURL(fileInput.files[0]);
                reader.onload=function(evt){
                    imgDiv.innerHTML="\<img src="+evt.target.result+"\>";
                }
            }else{//兼容ie9-
                imgDiv.innerHTML='<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + fileInput.value + '\)\';"></div>';
            }
        }
        function selectImg(fileInputs,imgDivs){
            var checkImg=new RegExp("(.jpg$)|(.png$)|(.bmp$)|(.jpeg$)","i");
            var i=0;
            for(;i<fileInputs.length&&i<imgDivs.length;i++){
                (function(i){//立即执行函数；保存i
                    fileInputs[i].onchange=function(){
                        if(checkImg.test(fileInputs[i].value)){
                            previewImg(this,imgDivs[i]);
                        }else{
                            alert("只支持上传.jpg .png .bmp .jpeg;你的选择有误");
                        }
                    };
                })(i);
            }

        }
        /* 为IE6 IE7 IE8增加document.getElementsByClassName函数 */
        /MSIE\s*(\d+)/i.test(navigator.userAgent);
        var isIE=parseInt(RegExp.$1?RegExp.$1:0);
        if(isIE>0&&isIE<9){
            document.getElementsByClassName=function(cls){
                var els=this.getElementsByTagName('*');
                var ell=els.length;
                var elements=[];
                for(var n=0;n<ell;n++){
                    var oCls=els[n].className||'';
                    if(oCls.indexOf(cls)<0)        continue;
                    oCls=oCls.split(/\s+/);
                    var oCll=oCls.length;
                    for(var j=0;j<oCll;j++){
                        if(cls==oCls[j]){
                            elements.push(els[n]);
                            break;
                        }
                    }
                }
                return elements;
            }
        }
        var fileInputs=document.getElementsByClassName("img-btn");//文件选择按钮
        var imgDivs=document.getElementsByClassName("img-container");//图片容器
        selectImg(fileInputs,imgDivs);
    </script>
    <script type="text/javascript">
    	function isExists(v){
    		
    		$.ajax({
    			type:'post',
    			url:'<%=request.getContextPath()%>/teacher_queryName.do',
    			data:{"teacher.tName":v},
    			success:function(msg){
    				alert(msg)
    			}
    		});
    	}
    
    
    </script>
</body>
</html>
