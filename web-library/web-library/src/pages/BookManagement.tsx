import { getBooks } from '@/services/library';
import { Button, Table } from 'antd';
import React, { useEffect, useState } from 'react';

function categoryType (dataIndex: number) {
    switch (dataIndex) {
        case 1:
            return "前端"
        case 2:
            return "后端"
        case 3:
            return "测试"
        case 4:
            return "产品"
        default:
            return ""
    }
}
function operationButton(dataIndex: number){
    return(
        <>
        <Button>修改</Button>
        <Button>删除</Button>
        </>
    )
}
const BookManagement: React.FC = () => {
    const [page, setPage] = useState<number>(1);
    const [dataSource, setDataSource] = useState<any>();
    const [total, setTotal] = useState<number|undefined>(1);

    useEffect(() => {
        fetchBooks(page);
    }, [page]);
    const fetchBooks = async (page: number) => {
        let result: BookPageDto = await getBooks(page);
        setDataSource(result.records);
        setPage(result.current!);
        setTotal(result.total);
    }

    const columns = [
        {
            title: '书名',
            dataIndex: 'bookName',
            key: 'bookName',
        },
        {
            title: '类别',
            dataIndex: 'categoryId',
            key: 'categoryId',
            render: categoryType,
        },
        {
            title: '子标题',
            dataIndex: 'subTitle',
            key: 'subTitle',
        },
        {
            title: '作者',
            dataIndex: 'author',
            key: 'author',
        },
        {
            title: '操作',
            dataIndex: 'bookId',
            render: operationButton,
        }
    ];
    const onPageChange = (page: any) => {
        setPage(page);
    }

    return <Table
    columns={columns}
    pagination={{current: page, onChange: onPageChange, position: ['bottomRight'], total: total}}
    dataSource={dataSource}
    />
}

export default BookManagement;