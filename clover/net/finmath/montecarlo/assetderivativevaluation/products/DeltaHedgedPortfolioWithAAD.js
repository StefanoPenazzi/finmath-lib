var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":203,"id":15589,"methods":[{"el":56,"sc":2,"sl":52},{"el":69,"sc":2,"sl":66},{"el":164,"sc":2,"sl":71},{"el":168,"sc":2,"sl":166},{"el":172,"sc":2,"sl":170},{"el":183,"sc":2,"sl":174},{"el":202,"sc":2,"sl":185}],"name":"DeltaHedgedPortfolioWithAAD","sl":33}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_21":{"methods":[{"sl":66},{"sl":71},{"sl":166},{"sl":170},{"sl":185}],"name":"testHedgePerformance[MonteCarloAssetModel [model=BlackScholesModel [initialValue=RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@2de23121,\n ID=0], riskFreeRate=RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@63475ace,\n ID=1], volatility=RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@4988d8b8,\n ID=2], abstractRandomVariableFactory=RandomVariableDifferentiableAADFactory [diracDeltaApproximationMethod=DISCRETE_DELTA, diracDeltaApproximationWidthPerStdDev=0.0, diracDeltaApproximationDensityRegressionWidthPerStdDev=0.5, isGradientRetainsLeafNodesOnly=false, toString()=AbstractRandomVariableDifferentiableFactory [randomVariableFactoryForNonDifferentiable=RandomVariableFromArrayFactory [isUseDoublePrecisionFloatingPointImplementation=true]]], initialState=[RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@c0c2f8d,\n ID=3]], drift=[RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@305b7c14,\n ID=6]], factorLoadings=[RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@4988d8b8,\n ID=2]]]]-EuropeanOption [maturity=5.0, strike=1.2840254166877414, underlyingIndex=0, nameOfUnderliyng=null]]","pass":true,"statements":[{"sl":67},{"sl":68},{"sl":75},{"sl":81},{"sl":83},{"sl":84},{"sl":85},{"sl":89},{"sl":91},{"sl":94},{"sl":95},{"sl":98},{"sl":99},{"sl":102},{"sl":103},{"sl":104},{"sl":106},{"sl":107},{"sl":109},{"sl":111},{"sl":112},{"sl":115},{"sl":116},{"sl":120},{"sl":122},{"sl":123},{"sl":128},{"sl":131},{"sl":133},{"sl":140},{"sl":141},{"sl":144},{"sl":145},{"sl":148},{"sl":149},{"sl":157},{"sl":158},{"sl":160},{"sl":163},{"sl":167},{"sl":171},{"sl":186},{"sl":188},{"sl":189},{"sl":192},{"sl":193},{"sl":194},{"sl":195},{"sl":196},{"sl":197},{"sl":201}]},"test_247":{"methods":[{"sl":66},{"sl":71},{"sl":166},{"sl":170},{"sl":185}],"name":"testHedgePerformance[MonteCarloAssetModel [model=BlackScholesModel [initialValue=RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@2de23121,\n ID=0], riskFreeRate=RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@63475ace,\n ID=1], volatility=RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@4988d8b8,\n ID=2], abstractRandomVariableFactory=RandomVariableDifferentiableAADFactory [diracDeltaApproximationMethod=DISCRETE_DELTA, diracDeltaApproximationWidthPerStdDev=0.0, diracDeltaApproximationDensityRegressionWidthPerStdDev=0.5, isGradientRetainsLeafNodesOnly=false, toString()=AbstractRandomVariableDifferentiableFactory [randomVariableFactoryForNonDifferentiable=RandomVariableFromArrayFactory [isUseDoublePrecisionFloatingPointImplementation=true]]], initialState=[RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@c0c2f8d,\n ID=3]], drift=[RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@305b7c14,\n ID=6]], factorLoadings=[RandomVariableDifferentiableAAD [values=net.finmath.stochastic.Scalar@4988d8b8,\n ID=2]]]]-AbstractMonteCarloProduct [currency=null]]","pass":true,"statements":[{"sl":67},{"sl":68},{"sl":75},{"sl":81},{"sl":83},{"sl":84},{"sl":85},{"sl":86},{"sl":89},{"sl":91},{"sl":94},{"sl":95},{"sl":98},{"sl":99},{"sl":102},{"sl":103},{"sl":104},{"sl":106},{"sl":107},{"sl":109},{"sl":111},{"sl":112},{"sl":115},{"sl":116},{"sl":120},{"sl":122},{"sl":123},{"sl":124},{"sl":128},{"sl":131},{"sl":133},{"sl":140},{"sl":141},{"sl":144},{"sl":145},{"sl":148},{"sl":149},{"sl":157},{"sl":158},{"sl":160},{"sl":163},{"sl":167},{"sl":171},{"sl":186},{"sl":188},{"sl":189},{"sl":192},{"sl":193},{"sl":194},{"sl":195},{"sl":196},{"sl":197},{"sl":201}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 247], [21, 247], [21, 247], [], [], [21, 247], [], [], [], [21, 247], [], [], [], [], [], [21, 247], [], [21, 247], [21, 247], [21, 247], [247], [], [], [21, 247], [], [21, 247], [], [], [21, 247], [21, 247], [], [], [21, 247], [21, 247], [], [], [21, 247], [21, 247], [21, 247], [], [21, 247], [21, 247], [], [21, 247], [], [21, 247], [21, 247], [], [], [21, 247], [21, 247], [], [], [], [21, 247], [], [21, 247], [21, 247], [247], [], [], [], [21, 247], [], [], [21, 247], [], [21, 247], [], [], [], [], [], [], [21, 247], [21, 247], [], [], [21, 247], [21, 247], [], [], [21, 247], [21, 247], [], [], [], [], [], [], [], [21, 247], [21, 247], [], [21, 247], [], [], [21, 247], [], [], [21, 247], [21, 247], [], [], [21, 247], [21, 247], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 247], [21, 247], [], [21, 247], [21, 247], [], [], [21, 247], [21, 247], [21, 247], [21, 247], [21, 247], [21, 247], [], [], [], [21, 247], [], []]