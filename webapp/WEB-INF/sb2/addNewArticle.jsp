<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/resources/js/ckeditor/ckeditor.js" />" type="text/javascript"></script>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Form</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Create new article
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-12">
                    
                    	<spring:url value="/article/add" var="actionUrl" />
                    	<c:if test="${message != null}">
                    		<p class="message"><c:out value="${message}"></c:out></p>
                    	</c:if>
						
                        <form role="form" action="${actionUrl}" method="post">
                            <div class="form-group">
                            	<div class="row">
                            		<div class="col-lg-10">
                            			<label>The title of the article</label>
                                		<input class="form-control" name="articleTitle" placeholder="Enter text">
                            		</div>
                            	</div>
                                
                            </div>
							
							<label>Choose tags</label>
							<div class="form-group">
								
								<c:forEach items="${tagList}" var="tag">
									<div class="tagItem">
										<label class="checkbox-inline">
                                    		<input type="checkbox" name="tagIds" value='<c:out value="${tag.tagId}"></c:out>'/>${tag.tagName}
                                		</label>
									</div>	
							    </c:forEach>
                                
                            </div>
                            
							<div class="form-group">
								<div class="row">
                            		<div class="col-lg-3">
                            			<label>Status</label>
		                                <select class="form-control">
		                                	<c:forEach items="${statusList}" var="status">
								    			<option value="${status.statusId}">${status.statusName}</option>
								    		</c:forEach>
		                                </select>
                            		</div>
                            	</div>
                            </div>

                            <div class="form-group">
                                <label>The content</label>
                                <textarea name="articleContent" id="editor1"></textarea>
                            </div>
							
							<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
							
                            <button type="submit" class="btn btn-default">Create</button>
                            <button type="reset" class="btn btn-default">Reset</button>
                        </form>
                    </div>
                    <!-- /.col-lg-6 (nested) -->

                </div>
                <!-- /.row (nested) -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script>
	CKEDITOR.replace( 'editor1' );
</script>

