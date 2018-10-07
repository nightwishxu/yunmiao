<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript">
        var grid;


        var delFun = function() {
            var rows = grid.datagrid('getSelections');
            if (rows.length == 0) {
                parent.$.messager.w('请选择需要删除的记录！');
                return;
            }
            parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
                if (r) {
                    var ids = [];
                    for ( var i = 0, l = rows.length; i < l; i++) {
                        var r = rows[i];
                        ids.push(r.id);
                    }
                    var id = ids.join(',');

                    $.post(sy.contextPath + '/pawnCate/del', {
                        id : id
                    }, function() {
                        rows.length = 0;//必须，否则有bug
                        grid.datagrid('reload');
                    }, 'json');
                }
            });
        };

        //邀请专家鉴定
        function choiceExperter(id){
            var url = sy.contextPath + '/go.do?path=authApply/experter/experterInfoEdit&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '专家评定',
                width : 800,
                height : 600,
                url : url,
                buttons : [ {
                    text : '确认',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }

        //复制链接地址发送给专家
        function copyUrl(id){
            var url = sy.contextPath + '/go.do?path=authApply/experter/url&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '链接地址',
                width : 800,
                height : 600,
                url : url,
            });
        }


        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/userGoods/list?type=onLine',
                columns : [ [{
                    width : $(this).width() * 0.2,
                    title : '用户账号',
                    field : 'account',
                    align : 'center'
                },{
                    width : $(this).width() * 0.2,
                    title : '提交时间',
                    field : 'createTime',
                    align : 'center',
                },{
                    width : $(this).width() * 0.2,
                    title : '用户昵称',
                    field : 'nickName',
                    align : 'center'
                },{
                    width : $(this).width() * 0.2,
                    title : '宝贝类别',
                    field : 'cateName',
                    align : 'center'
                }, {
                    width : $(this).width() * 0.3,
                    title : '宝贝图片',
                    field : 'images',
                    align : 'center',
                    formatter : function (value,row,index) {
                        return po.showImg(value,20,20);
                    }
                },{
                    width : $(this).width() * 0.3,
                    title : '宝贝附件',
                    field : 'goodsImgs',
                    align : 'center',
                    formatter : function (value,row,index) {
                        return po.showImg(value,20,20);
                    }
                },{
                    width : $(this).width() * 0.2,
                    title : '宝贝视频',
                    field : 'video',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if(v){
                            return "<a href='javascript:;' onclick='parent.sy.showVideo(\""+v+"\")' class='button button-blue'>查看宝贝视频</a>";
                        }else{
                            return '未上传视频';
                        }
                    }
                },{
                    width : $(this).width() * 0.2,
                    title : '估价',
                    field : 'PriceTest',
                    align : 'center',
                    formatter : function (v,r,i){
                        if(!r.authPriceTest){
                            return '<a href="javascript:void(0);" onclick="gujia(\''+r.id+'\');" class="button button-warning" title="估价">估价</a>';
                        }else{
                            return r.authPriceTest;
                        }

                    }
                },{
                    width : $(this).width() * 0.2,
                    title : '专家鉴定',
                    field : 'auth',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if(r.experterInfoId != 0 ){
                            return   '<a id="copyUrl" href="javascript:void(0);" class="button button-info" onclick="copyUrl(\''+r.experterInfoId+'\')" title="复制url">复制url</a>';
                        }else{
                            return    '<a href="javascript:void(0);" onclick="choiceExperter(\''+r.id+'\');" class="button button-info" title="专家鉴定">专家鉴定</a>';
                        }
                    }
                }
                /*,{
                    width : $(this).width() * 0.2,
                    title : '详情',
                    field : 'operation',
                    align : 'center',
                    formatter : function(value,row,index){
                        var html = "";
                        return html+= "<a href='javascript:;' onclick=\"getDetail('"+row.id+"')\">查看详情</a>"
                    }
                }*/
                ] ]
            });
        });


        // 估价
        function  gujia(id) {
            var url = sy.contextPath +'/go.do?path=authApply/authPriceTest&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '估价',
                width : 400,
                height : 350,
                url : url,
                buttons : [ {
                    text : '确认',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }

//        //在线鉴定
//        function operGoods(id){
//            var url = sy.contextPath +'/go.do?path=authApply/authOnLineoper&id=' + id;
//            var dialog = parent.sy.modalDialog({
//                title : '鉴定结果',
//                width : 400,
//                height : 420,
//                url : url,
//                buttons : [ {
//                    text : '确认',
//                    handler : function() {
//                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
//                    }
//                } ]
//            });
//        }

        //查看详情
        function getDetail(id){
            var url = sy.contextPath +'/go.do?path=authApply/onLineDetail/onLineDetail&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '查看详情',
                width : 800,
                height : 600,
                url : url,
            });
        }
    </script>
</head>
<body>
<div id="toolbar">
    <form id="searchForm">
        <div>
            <%--<input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="宝贝名称"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>--%>
        </div>
    </form>
    <div class="tbbutton">
        <div>

        </div>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false">


</table>
</body>
</html>