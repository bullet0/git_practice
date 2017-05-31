<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        .span1{float: left;display: none;height: 40px;}
        .span2{float: left;display: inline-block;height: 40px;}
        .box{margin: 1px auto;padding: 1px ;}
        .span1{width: 150px;position: relative;}
        .img-btn{border: 0 none;height: 20px;width: 140px;padding: 10px 5px;position: absolute;top: 0;}
        .img-container{height: 40px;font: normal 18px/40px "微软雅黑";}
    </style>

<script language="javascript" type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
</head>
<body>

	<form action="<%=request.getContextPath() %>/teacher_update.do" id="f1" method="post" enctype="multipart/form-data">
		<input type="hidden" name="teacher.tId" value="<s:property value="#teacher.tId"/>">
		<table>
			<tr>
				<td>姓名</td>
				<td choose='choose'><s:property value="#teacher.tName"/></td>
			</tr>
			<tr>
				<td>头像</td>
				<td choose='choose'>
					<span class="span1">
				            <input class="img-btn" type="file" id="drivingLicence" name="file">
				    </span>
				    <span class="span2">
				        	<div class="img-container"><img alt="头像" width="50px" height="50px" src='http://localhost:8888/maven_spring_demo/img/myfile/<s:property value="#teacher.tHeadImg"/>'/></div>
				    </span>
					
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td choose='choose'><s:property value="#teacher.tSex.dValue"/></td>
			</tr>
			
			<tr>
				<td>工资</td>
				<td choose='choose'><s:property value="#teacher.tSalary"/></td>
			</tr>
			
			<tr>
				<td>身份证号</td>
				<td choose='choose'><s:property value="#teacher.tIdcard"/></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td choose='choose'><s:property value="#teacher.tAge"/></td>
			</tr>
			<tr>
				<td>入职日期</td>
				<td choose='choose'><s:date name="#teacher.tStartdate" format="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>离职日期</td> 
				<td choose='choose'><s:date name="#teacher.tEnddate" format="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>在职状态</td>
				<td choose='choose'><s:property value="#teacher.tState.dValue"/></td>
			</tr>
		</table>
	
	</form>
	<button onclick="return toUpdate(this)" action="update">修改</button>
	
	
	<script type="text/javascript">
	
		
		var names = new Array("tName","tHeadImg","tSex","tSalary","tIdcard","tAge","tStartdate","tEnddate","tState");
		function toUpdate(tis){
			var action = $(tis).attr("action");
			
			if(action == "update"){
				$("td[choose='choose']").each(function(i){
					
					if($(this).prev().html()  == "性别"){
						var sex = $(this).html();
						$(this).html("");
						if(sex == "男"){                                              
							$(this).html("男<input type='radio' checked='true'  name='teacher.tSex.dId' value='1'> 女<input type='radio'  name='teacher.tSex.dId' value='2'>");
						}else{
							$(this).html("男<input type='radio'  name='teacher.tSex.dId' value='1'> 女<input type='radio' checked='true' name='teacher.tSex.dId' value='2'>");
						}
					}else if($(this).prev().html()  == "在职状态"){
						//如果是在职状态特殊处理
						var state = $(this).html();
						$(this).html("");
						if(state == "在职"){
							$(this).html("<select name='teacher.tState.dId'><option selected='selected' value='3'>在职</option><option value='4' >离职</option></select>");
						}else{
							$(this).html("<select name='teacher.tState.dId'><option value='3'>在职</option><option value='4'  selected='selected'>离职</option></select>");
						}
					}else if($(this).prev().html().match(/.*日期$/)){
						//如果是时间点特殊处理
						var inp = $("<input>");
						inp.attr("name","teacher."+names[i]);
						inp.val($(this).html());
						inp.addClass("Wdate");
						inp.click(WdatePicker);
						$(this).html("");
						$(this).append(inp);
					}else if($(this).prev().html() == "头像"){
						//如果是头像特殊处理
						
						
						$(".span1").css("display","inline-block");
						
					}else{
						var inp = $("<input>");
						inp.attr("name","teacher."+names[i]);
						inp.val($(this).html());
						$(this).html("");
						$(this).append(inp);
					}	
				
				});
				tis.innerHTML="保存修改"
				$(tis).attr("action","save");
				
				var btn = $("<button>返回</button>")
				btn.click(function(){
					window.history.back();
				});
				$("body").append(btn);
				
				
				
			}else if(action == "save"){
				var flag = confirm("确定要保存么？")
				if(flag){
					tis.innerHTML="修改";
					$(tis).attr("action","update");
					$("#f1").submit();
				}
			}
			
			return false;
		}
	
	</script>
	
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
</body>
</html>