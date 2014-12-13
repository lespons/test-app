/**
 * Created by lespons on 12.12.14.
 */
$(document).ready(function () {
    var app = {
        init: function () {
            function FilesViewModel() {
                var self = this;
                var rootPath = 'sys';

                function getFiles(files, parentId, rootPath) {
                    $.ajax({
                        method: 'get',
                        url: '/rest/file/list?id=' + (parentId || '')
                    }).done(function (data) {
                            self.folderFiles([]);
                            for (var i in data) {
                                var d = data[i];
                                d.openFile = openFile;
                                d.files = ko.observableArray();
                                d.path = ko.observable(rootPath + '/' + d.name);
                                if (d.type === 'folder') {
                                    files.push(d);
                                }
                                self.folderFiles.push(d);
                            }
                        });
                }

                var openFile = function (file, e) {
                    e.stopPropagation();

                    switch (file.type) {
                        case 'sys':
                        case 'folder':
                        {
                            var _files = file.files;

                            self.path(self == file ? rootPath : (file.path() || ''));
                            var $i = $("[id=" + file.id + "] > span").find(" > i");
                            if (_files().length === 0) {//показываем обновленные файлы
                                getFiles(_files, file.id, self.path());
                                $i.removeClass('icon-folder-close').addClass('icon-folder-open');
                            } else {//прчем файлы
                                self.folderFiles(_files());
                                _files([]);
                                $i.removeClass('icon-folder-open').addClass('icon-folder-close');
                            }
                        }
                            break;
                        case 'textfile':
                        {
                            alert(file.content);
                        }
                            break;
                        default:
                            alert('No supported type file');
                    }
                }
                self.openFile = openFile;
                self.files = ko.observableArray();
                self.folderFiles = ko.observableArray();
                self.type = rootPath;
                self.path = ko.observable(rootPath);
                getFiles(self.files, "", self.path());
            }

            ko.applyBindings(new FilesViewModel());
        }
    }
    app.init();
});