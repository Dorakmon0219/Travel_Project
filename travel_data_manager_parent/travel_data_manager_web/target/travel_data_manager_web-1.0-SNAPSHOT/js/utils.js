function getQuarter(month_num) {
    if (month_num >= 1 && month_num <= 3) {
        return "第一季度"
    }
    if (month_num >= 4 && month_num <= 6) {
        return "第二度"
    }
    if (month_num >= 7 && month_num <= 9) {
        return "第三季度"
    }
    if (month_num >= 10 && month_num <= 12) {
        return "第四季度"
    }
}

function processData(orderList, beginYear) {
    let endYear = new Date().getFullYear();
    let endMonth = new Date().getMonth() + 1;
    let res = {}
    for (let begin = beginYear; begin < endYear; begin++) {
        res[begin + "第一季度"] = 0;
        res[begin + "第二季度"] = 0;
        res[begin + "第三季度"] = 0;
        res[begin + "第四季度"] = 0;
    }
    for (let month = 1; month <= endMonth; month++) {
        res[endYear + getQuarter(month)] = 0;
    }

    for (let i in orderList) {
        let order=orderList[i]
        let orderTime = order.orderTimeStr;
        console.log(order)
        let year = parseInt(orderTime.split("-")[0]);
        let month = parseInt(orderTime.split("-")[1]);
        let key = year + getQuarter(month);
        if(Object.keys(res).includes(key)){
            res[key] += order.product.productPrice;
        }
    }
    console.log(res)
    return res;
}

function getXAxis(dict) {

}