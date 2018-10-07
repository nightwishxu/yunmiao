<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/static/admin/jsp/include.jsp"%>
    <script type="text/javascript" src="${path}/static/admin/js/datagrid-cellediting.js"></script>
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

        var editFun = function() {
            var rows = grid.datagrid('getSelections');
            if (rows.length != 1) {
                parent.$.messager.w('请选择一条记录进行编辑！');
                return;
            }
            var dialog = parent.sy.modalDialog({
                title : '编辑信息',
                width : 800,
                height : 600,
                url : sy.contextPath + '/go?path=authApply/editGoodsImg&id=' + rows[0].id,
                buttons : [ {
                    text : '编辑',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };


        $(function() {
            grid = $('#grid').datagrid({
                url : sy.contextPath + '/userGoods/list?type=mail',
                columns : [ [ {
                    width : $(this).width() * 0.15,
                    title : '宝贝名称',
                    field : 'name',
                    align : 'center',
                    formatter : function (value,row,index){
                        if(value!=null && value!=undefined && value!=""){
                            return value;
                        }else{
                            return "<a href='javascript:;' onclick='setGoodsName(\""+row.id+"\")' class='button button-blue'>为宝贝命名</a>";
                        }

                    }
                },
                {
                    width : $(this).width() * 0.2,
                    title : '物流单号',
                    field : 'postExpressCode',
                    align : 'center',
                    formatter : function (value,row,index) {
                        var html = "";
                        if(value !=null){
                             if(row.postState == 3 || row.postState == 4){
                                 html += "<span>"+value+"</span>"
                             }else{
                                 html += "<a href='javascript:;' onclick='updateExpressCode(\""+row.id+"\")' class='button button-blue'>"+value+"</a>";
                             }
                        }else{
                            return html;
                        }
                        return html;
                    }
                },
                {
                    width : $(this).width() * 0.2,
                    title : '宝贝图片',
                    field : 'images',
                    align : 'center',
                    formatter : function (value,row,index) {
                        return po.showImg(value,20,20);
                    }
                },{
                        width : $(this).width() * 0.15,
                        title : '宝贝附件',
                        field : 'goodsImgs',
                        align : 'center',
                        formatter : function (value,row,index) {
                            return po.showImg(value,20,20);
                        }
                },{
                    width : $(this).width() * 0.2,
                    title : '宝贝邮寄打包视频',
                    field : 'goVideo',
                    align : 'center',
                    formatter : function (v,r,i) {
                        if(v){
                            return "<a href='javascript:;' onclick='parent.sy.showVideo(\""+v+"\")' class='button button-blue'>查看打包视频</a>";
                        }else{
                            return '未上传视频';
                        }
                    }
                },{
                        width : $(this).width() * 0.2,
                        title : '快递状态',
                        field : 'postState',
                        align : 'center',
                        formatter : function (v,r,i) {
                          if(v){
                              if(v == 2){
                                  return '邮寄中';
                              }else if(v == 3){
                                  return '平台确认';
                              }else if(v == 4){
                                  return '已经到货';
                              }
                          }
                        }
                },{
                    width : $(this).width() * 0.1,
                    title : '鉴定结果',
                    field : 'authResult',
                    align : 'center',
                    formatter : function (value, row, inex) {

                        if(0 == value){
                            return '未鉴定';
                        }else if(1 == value) {
                            return '鉴定中';
                        }else if(2 == value){
                            return '无法鉴定';
                        }else if(3 == value){
                            return '赝品';
                        }else if(4 == value){
                            return '真品';
                        }
                    }
                },{
                    width : $(this).width() * 0.2,
                    title : '拆箱视频',
                    field : 'openGoodsVideo',
                    align : 'center',
                    formatter : function (v,r, i) {
                        if(v){
                            return "<a href='javascript:;' onclick='parent.sy.showVideo(\""+v+"\")' class='button button-blue'>查看拆箱视频</a>";
                        }else{
                            return '暂未上传拆箱视频';
                        }
                    }
                },{
                    width : $(this).width() * 0.2,
                    title : '鉴宝视频',
                    field : 'platGoodsAuthVideo',
                    align : 'center',
                    formatter : function (v,r, i) {
                        if(v){
                            return "<a href='javascript:;' onclick='parent.sy.showVideo(\""+v+"\")' class='button button-blue'>查看鉴宝视频</a>";
                        }else{
                            if(r.authResult == 1 && r.postState == 3){
                                //判断是否已经开始鉴定
                                return "<a href='javascript:;' onclick='uploadAuthGoodVideo(\""+r.id+"\")' class='button button-red'>上传鉴宝视频</a>";
                            }else{
                                return null;
                            }

                        }
                    }
                },{
                    width : $(this).width() * 0.1,
                    title : '鉴定价',
                    field : 'authPrice',
                    align : 'center'
                },{
                    width : $(this).width() * 0.25,
                    title : '操作',
                    field : 'operations',
                    align : 'center',
                    formatter : function(value,row,index){
                        if(row.gotoPawn != 1){
                            //用户还未去典当
                            //平台还未收到宝贝
                            if(row.power == 0){
                                if(row.isVerify != 1){
                                    if(row.postState == 4 && row.isVerify == 0 ){
                                        return '<a href="javascript:void(0);" onclick="openGoods(\''+row.id+'\');" class="button button-warning" title="开始拆箱">开始拆箱</a>';
                                    }else if(row.postState == 3 && row.isVerify == 0 ){
                                        if(row.authResult == 0 || row.authResult == -1 ){

                                            if(row.experterInfoId != 0 ){
                                                return '<a href="javascript:void(0);" onclick="beginToOper(\''+row.id+'\');" class="button button-warning" title="开始鉴定">开始鉴定</a>' +
                                                       '<a id="copyUrl" href="javascript:void(0);" class="button button-info" onclick="copyUrl(\''+row.experterInfoId+'\')" title="复制url">复制url</a>';
                                            }else{
                                                return '<a href="javascript:void(0);" onclick="beginToOper(\''+row.id+'\');" class="button button-warning" title="开始鉴定">开始鉴定</a>' +
                                                       '<a href="javascript:void(0);" onclick="choiceExperter(\''+row.id+'\');" class="button button-info" title="专家鉴定">专家鉴定</a>';
                                            }

                                        }else if(row.authResult == 1 && row.platGoodsAuthVideo != "" && 0 == row.power){
                                            if(row.name == '' || row.name == undefined || row.name == 'undefined'){
                                                return parent.$.messager.w('请先为宝贝命名');
                                            }else{
                                                return '<a href="javascript:void(0);" onclick="operGoods(\''+row.id+'\');" class="button button-warning" title="设置鉴定结果">设置鉴定结果</a>';
                                            }

                                        }else if(row.authResult == 4){

                                            return '<a href="javascript:void(0);" onclick="beginToOper(\''+row.id+'\');" class="button button-warning" title="再次鉴定">再次鉴定</a>';
                                        }
                                    }
                                }else{
                                    return '已经认证！';
                                }

                            }else if(row.power == 1){
                                if( 2 == row.authResult || 3 == row.authResult || 4 == row.authResult){
                                   if(row.isVerify == 0){
                                       //认证
                                       return '<a href="javascript:void(0);" onclick="verifyGoods(\''+row.id+'\');" class="button button-warning" title="设置鉴定结果">确认</a>';
                                   }else{
                                       return '已经认证！';
                                   }
                                }else{
                                    return '请先鉴定'
                                }
                            }

                        }else{
                            //用户已经去典当，平台不可操作
                            return '<a href="javascript:void(0);" class="button button-red" title="宝贝已典当">宝贝已典当</a>';
                        }
                    }
                },{
                    width : $(this).width() * 0.15,
                    title : '回寄给用户',
                    field : 'postToUser',
                    align : 'center',
                    formatter : function(value,row,index){
                        if(row.backState == 1){
                            return '<a href="javascript:void(0);" onclick="postToUser(\''+row.id+'\');" class="button button-warning" title="回寄给用户">回寄给用户</a>';
                        }else if(row.backState == 2){
                            return '已经回寄给用户物流单号为：'+row.backExpressCode;
                        }

                    }
                },{
                    width : $(this).width() * 0.15,
                    title : '详情',
                    field : 'detail',
                    align : 'center',
                    formatter : function(value,row,index){
                        var html = "";
                        return html+= "<a href='javascript:;' onclick=\"getDetail('"+row.id+"')\">查看详情</a>"
                    }
                },
                ] ],
                onBeforeEdit:function (index, row) {
                    if (row.postState > 2){
                        return true;
                    }
                    return false;
                },
                onEndEdit:function (index, row, changes) {
                    if (!$.isEmptyObject(changes)){
                        changes.id = row.id;
                        save(changes);
                    }else{
                        grid.datagrid('resize');
                    }
                }
            });
            $('#type').combobox({
                onSelect: function(rec){
                    grid.datagrid('load',sy.serializeObject($('#searchForm')));
                }
            });
        });

        function save(data) {
            $.post(sy.contextPath +'userGoods/save', data, function() {
                grid.datagrid('reload');
            }, 'json');
        }

        //设置宝贝名称
        function setGoodsName(id){
            var url = sy.contextPath +'/go.do?path=authApply/setGoodsName&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '设置宝贝名称',
                width : 400,
                height : 420,
                url : url,
                buttons : [ {
                    text : '确认',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }

        //修改订单号
        function updateExpressCode(id){
            var url = sy.contextPath +'/go.do?path=authApply/updateExpressCode&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '修改订单号',
                width : 400,
                height : 420,
                url : url,
                buttons : [ {
                    text : '确认',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }

        //开始鉴定
        function beginToOper(id){
            var url = sy.contextPath +'/userGoods/save';
            var data = {
                id : id,
                authResult : 1,
            }
            $.post(url, data, function() {
                grid.datagrid('reload');
            }, 'json');
        }

        //鉴定者鉴定
        function  verifyGoods(id) {
            var url = sy.contextPath +'/userGoods/authAdminVerify';
            var data = {
                id : id,
                isVerify : 1
            }
            $.post(url, data, function() {
                grid.datagrid('reload');
            }, 'json');
        }

        //拆箱
        function openGoods(id){
            var url = sy.contextPath +'/go.do?path=authApply/openGoods&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '上传拆箱视频',
                width : 400,
                height : 420,
                url : url,
                buttons : [ {
                    text : '确认',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }

        //上传鉴宝视频
        function uploadAuthGoodVideo(id){
            var url = sy.contextPath +'/go.do?path=authApply/uploadAuthGoodVideo&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '上传鉴宝视频',
                width : 400,
                height : 420,
                url : url,
                buttons : [ {
                    text : '确认',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }

        //拒绝收货原因
        function refuseReason(id){
            var url = sy.contextPath +'/go.do?path=authApply/refuseReason&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '拒绝收货原因',
                width : 400,
                height : 420,
                url : url,
                buttons : [ {
                    text : '确认',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }

        //邮寄鉴定
        function operGoods(id){
            var url = sy.contextPath +'/go.do?path=authApply/authMailOper&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '鉴定结果',
                width : 400,
                height : 420,
                url : url,
                buttons : [ {
                    text : '确认',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        }

        //回寄给用户
        function postToUser(id){
            var url = sy.contextPath +'/go.do?path=authApply/backToUser/backToUser&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '回寄用户',
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

        //查看详情
        function getDetail(id){
            var url = sy.contextPath +'/go.do?path=authApply/mailDetail/mailDetail&id=' + id;
            var dialog = parent.sy.modalDialog({
                title : '查看详情',
                width : 800,
                height : 600,
                url : url,
            });
        }

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
    </script>
</head>
<body>
<div id="toolbar">
    <form id="searchForm">
        <div>
            <input type="text" class="easyui-textbox" name="name" style="width: 150px" prompt="宝贝名称"/>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search'" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-search-minus'" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
        </div>
    </form>
    <div class="tbbutton">
        <div>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'fa-pencil',plain:true" onclick="editFun();">修改图片</a>
        </div>
    </div>
</div>
<table id="grid" data-options="fit:true,border:false">


</table>
</body>
</html>