Ext.Loader.setConfig({enabled: true});

Ext.Loader.setPath('Ext.ux', './resources/ext/ux/');
Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
    'Ext.toolbar.Paging',
    'Ext.ux.PreviewPlugin',
    'Ext.ModelManager',
    'Ext.tip.QuickTipManager'
]);

Ext.onReady(function(){
    Ext.tip.QuickTipManager.init();

    Ext.define('ForumThread', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            'name', 
            'sex',
            'birthday'
        ],
        idProperty: 'id'
    });

    // create the Data Store
    var store = Ext.create('Ext.data.Store', {
        pageSize: 4,
        model: 'ForumThread',
        remoteSort: true,
        proxy: {
            type: 'ajax',
            url: 'http://localhost:8080/cfo/student/list/json',
            reader: {
                root: 'result',
                totalProperty: 'totalRecords'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        sorters: [{
            property: 'id',
            direction: 'asc'
        }]
    });

    var pluginExpanded = true;
    var grid = Ext.create('Ext.grid.Panel', {
        width: 500,
        height: 300,
        title: '学员列表',
        store: store,
        disableSelection: false,
        loadMask: true,			//加载提示{ msg: '正在加载数据，请稍侯……'
        selModel: new Ext.selection.CheckboxModel, //添加checkbox列
        // grid columns
        columns:[{
            text: "ID",
            dataIndex: 'id',
            // hidden : true,
            sortable: true
        },{
            text: "用户名",
            dataIndex: 'name',
            width: 100,
            sortable: true
        },{
            text: "性别",
            dataIndex: 'sex',
            width: 70,
            align: 'center',
            sortable: true
        },{
            text: "出生日期",
            dataIndex: 'birthday',
            width: 150,
            // renderer: renderLast,
            sortable: true
        }],
        // paging bar on the bottom
        bbar: Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true,
            displayMsg: '显示第{0}-{1}条  共:{2}条',
            emptyMsg: "没有数据!"
        }),
        renderTo: 'topic-grid'
    });

    // trigger the data store load
    store.loadPage(1);
});
