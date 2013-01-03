
Ext.onReady(function () {
    Ext.create('Ext.container.Viewport', {
        layout: 'border',
        items: [{
            region: 'north',
            html: '<h1>CFO</h1>',
            xtype: "panel",
            autoHeight: true,
            border: false,
            margins: '0 0 5 0'
        }, {
            region: 'west',
            title: '导航',
            collapsible: true,
            xtype: 'panel',
            width: 200,
            autoScroll: true,
            items:[{
            	xtype:'button',
            	text:'按钮'
            }]
        }, {
            region: 'center',
            xtype: 'tabpanel',
            activeItem: 0,
            items: [{
                title: '首页',
                html: '这里是首页正文内容',
                closable: true
            }, {
                title: 'TAB',
                html: 'hello word'
            }]
        }]
    });
});